package userservice.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserHandle implements InvocationHandler {

	Object object ; 
	
	public UserHandle(Object object) {
		this.object = object ;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("调用方法前:");
		method.invoke(object, args);//调用真实的方法
		System.out.println("调用方法后:");
		return null ;
	}

}
