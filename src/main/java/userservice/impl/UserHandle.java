package userservice.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserHandle implements InvocationHandler {

	Object object ; 
	
	public UserHandle(Object object) {
		this.object = object ;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("���÷���ǰ:");
		method.invoke(object, args);//������ʵ�ķ���
		System.out.println("���÷�����:");
		return null ;
	}

}
