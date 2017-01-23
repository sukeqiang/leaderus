package fourthLessons;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	
	private final Logger logger = LoggerFactory.getLogger(MyBeanPostProcessor.class);
		
	public MyBeanPostProcessor() {
		logger.info("init:MyBeanPostProcessor!");
	}
	

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Field[] fields = bean.getClass().getDeclaredFields();
		if(fields.length > 4) {
			logger.info("warning ".concat(beanName).concat(" has ").concat(fields.length+"").concat(" properties"));
			for(Field field : fields) {
				logger.info("property ".concat(field.getName()).concat(" type ").concat(field.getType().getName()));
			}
		}
		Class<?>[] interfaces = bean.getClass().getInterfaces();
		if(interfaces.length>2) {
			logger.info("warning ".concat(beanName).concat(" has ").concat(interfaces.length+"").concat(" interfaces"));
			for(Class<?> interfaceClass : interfaces) {
				logger.info("interface ".concat(interfaceClass.getSimpleName()).concat(" type ").concat(interfaceClass.getTypeName()));
			}
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
