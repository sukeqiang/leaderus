package userservice.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyUser implements InvocationHandler {

	Object object ; 
	
	public ProxyUser(Object object) {
		this.object = object ;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object o = method.invoke(object, args);//调用真实的方法
		return o ;
	}

}
