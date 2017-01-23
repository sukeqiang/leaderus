package myframework.framework.annotation.bean;

public class AnnotatedGenericBeanDefinition {
	
	private String beanName;
	
	private Class<?> beanClass;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public Class<?> getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class<?> beanClass) {
		this.beanClass = beanClass;
	}
}
