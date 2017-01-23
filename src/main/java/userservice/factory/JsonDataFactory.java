package userservice.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import userservice.bean.User;
import userservice.impl.ClassPathResource;
import userservice.impl.FileSystemResource;
import userservice.impl.JsonDataHandle;
import userservice.impl.ProxyUser;
import userservice.interfaces.DataHandle;
import userservice.interfaces.Resource;
import userservice.resolver.ChainResolver;
import userservice.resolver.ClasspathResourceResolver;
import userservice.resolver.FilesystemResourceResolver;
import userservice.utils.Utils;

public class JsonDataFactory extends HandleFactory<DataHandle<User>> {
	
	/*
	 * ��json��Ϊ�ļ��洢�ķ�ʽ�����û�����
	 * @see userservice.DataHandleFactory#createDataHandle(java.lang.String)
	 */
	@Override
	public DataHandle<User> instance(String fileName) {
		//ͨ���������ҵ����ʵļ���
		Resource resource = new FilesystemResourceResolver()
				.setNext(new ClasspathResourceResolver())
				.resolver(fileName) ;
		DataHandle<User> datahandle = new JsonDataHandle(resource,fileName) ;
		//�����ݲ������ж�̬����
		InvocationHandler proxUser = new ProxyUser(datahandle) ;
		datahandle = (DataHandle<User>)Proxy.newProxyInstance(proxUser.getClass().getClassLoader(), 
						datahandle.getClass().getInterfaces(),proxUser) ;
		return datahandle;
	
	}
}
