package myframework.framework.context;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.reflections.Reflections;
import org.springframework.core.ResolvableType;

import myframework.framework.annotation.bean.AnnotatedGenericBeanDefinition;
import myframework.framework.annotation.Autowired;
import myframework.framework.annotation.Component;

import org.springframework.util.Assert;

public class LdIocFactory {
	
	//定义简易容器
	private final Map<String, Object> singltonBeanMap = new ConcurrentHashMap<String, Object>(256);
	
	public LdIocFactory(String... basePackages) {
		scan(basePackages);
	}
	/*
	 * 超简易版getBean
	 */
	public  Object getBean(Class<?> requiredType) {
		Object bean = singltonBeanMap.get(requiredType.getName());
		if(bean == null) {
			//这部分应该使用扫描那部分程序(除扫描部分)，逻辑基本上差不多，这里就简单处理了
			bean = createBean(requiredType);
		}
		return bean;
	}
	
	//超简易版初始化bean
	public <T> Object createBean(Class<T> requiredType) {
		Object bean = null;
		try {
			bean = requiredType.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		singltonBeanMap.put(requiredType.getName(), bean);
		return bean;
	}
	
	public void scan(String... basePackages){
		//检查空值
		Assert.notEmpty(basePackages, "At least one base package must be specified");
		try{
			doScan(basePackages);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//超简易版自动扫描注入
	public void doScan(String... basePackages) throws Exception {
		for(String basePackage : basePackages) {
			//找到候选的组件封装到bean里,为后续使用，候选组件为：UserDao,LDOrderDao,UserService,LDOrderService
			Set<AnnotatedGenericBeanDefinition> candidates = findCandidateComponents(basePackage);
			for (AnnotatedGenericBeanDefinition candidate : candidates) {
				//初始化注册到容器中
				registerBeanDefinition(candidate);
			}
			//通过泛型候选bean注入他的父类所依赖的泛型成员变量
			//例如：
			//public class AbstractService<T>
			//@Autowired 
			//private AbstractDao<T> abstractDao;
			for (AnnotatedGenericBeanDefinition candidate : candidates) {
				String beanName = candidate.getBeanName();
				//从容器中获取候选bean的实例
				Object candidateBean = singltonBeanMap.get(beanName);
				Class<?> candidatesBeanClass = candidateBean.getClass();
				//根据bean获取泛型的真实类别
				String genericTypeName=ResolvableType.forClass(candidatesBeanClass).getSuperType().getGeneric(0).resolve().getName();
				//获取父类的成员变量
				Field[] fields =  candidatesBeanClass.getSuperclass().getDeclaredFields();
				for(Field field : fields) {
					inject(field,candidateBean,beanName,genericTypeName,candidates);
				}
			}
		}
	}
	
	/*
	 * 超简易版注入属性值
	 */
	private void inject(Field field,Object candidateBean,String beanName,String genericTypeName,Set<AnnotatedGenericBeanDefinition> candidates) throws Exception{
		//获取依赖注入注解
		Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
		if(autowiredAnnotation != null) {
			//加载泛型的CLASS
			Object autowiredBean = null;
			for (AnnotatedGenericBeanDefinition candidateTmp : candidates) {
				String tmpBeanName = candidateTmp.getBeanName();
				//找到自己本身不处理
				if(tmpBeanName.equals(beanName)) {continue;}
				autowiredBean = singltonBeanMap.get(tmpBeanName);
				//autowiredBean是否是泛型成员变量的子类(校验UserDao、orgDao是否是AbstractDao的子类)
				boolean isAssignableFrom = field.getType().isAssignableFrom(autowiredBean.getClass());
				//校验autowiredBean泛型类型与当前要处理的泛型子类类型是否一样(UserDao、orgDao与UserService、orgService的泛型类型是否一致)
				boolean isTypeName = ResolvableType.forClass(autowiredBean.getClass()).getSuperType()
						.getGeneric(0).resolve().getName()
						.equals(genericTypeName);
				//都通过才说明autowiredBean可以注入到泛型的成员变量(AbstractDao<User> = new UserDao<User>())
				if(isAssignableFrom && isTypeName) {
					break;
				}//没有依赖子类无法使用(AbstractDao<T>没有？干嘛要它。。。)
				else{autowiredBean = null;}
			}
			Assert.notNull(autowiredBean,"find not autowiredBean!");
			try {
				//不用set方法原因在这里，直接设置属性为可写的。。。，貌似是违背了....，但是没事，哥能反射
				field.setAccessible(true);
				//注入的核心，给成员变量赋值，AbstractDao<User> = new UserDao<User>()，这样就能拿到具体类型的类
				field.set(candidateBean, autowiredBean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 超简易版找到候选组件
	 */
	private Set<AnnotatedGenericBeanDefinition> findCandidateComponents(String basePackage) {
		Reflections reflections = new Reflections(basePackage);
		Set<Class<?>> set = reflections.getTypesAnnotatedWith(Component.class);
		Set<AnnotatedGenericBeanDefinition> candidates = new LinkedHashSet<AnnotatedGenericBeanDefinition>();
		Iterator<Class<?>> iterator = set.iterator();
		while(iterator.hasNext()){
			Class<?> beanClass = iterator.next();
			AnnotatedGenericBeanDefinition definition = new AnnotatedGenericBeanDefinition();
			definition.setBeanName(beanClass.getName());
			definition.setBeanClass(beanClass);
			candidates.add(definition);
		}
		return candidates;
	}
	
	/*
	 * 超简易版初始化bean，并注入到容器
	 */
	private void registerBeanDefinition(AnnotatedGenericBeanDefinition candidate) throws Exception {
		Class<?> beanClass = candidate.getBeanClass();
		try{
			//最简化的处理，直接把候选的bean实例化，只考虑单例
			singltonBeanMap.put(beanClass.getName(),beanClass.newInstance());
		} catch (Exception e) {
			throw new Exception("bean instance fail! ".concat(beanClass.getName()));
		}
	}
}
