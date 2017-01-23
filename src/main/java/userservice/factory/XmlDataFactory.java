package userservice.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.apache.commons.lang.StringUtils;

import userservice.bean.User;
import userservice.impl.ClassPathResource;
import userservice.impl.FileSystemResource;
import userservice.impl.JsonDataHandle;
import userservice.impl.ProxyUser;
import userservice.impl.XmlDataHandle;
import userservice.interfaces.DataHandle;
import userservice.interfaces.Resource;
import userservice.resolver.ChainResolver;
import userservice.resolver.ClasspathResourceResolver;
import userservice.resolver.FilesystemResourceResolver;
import userservice.utils.Utils;

public class XmlDataFactory extends HandleFactory<DataHandle<User>> {
	
	/*
	 * 用xml作为文件存储的方式处理用户数据
	 * @see userservice.DataHandleFactory#createDataHandle(java.lang.String)
	 */
	@Override
	public DataHandle<User> instance(String fileName) {
		//通过责任链找到合适的加载
		Resource resource = new FilesystemResourceResolver()
				.setNext(new ClasspathResourceResolver())
				.resolver(fileName)  ;
		DataHandle<User> datahandle = new XmlDataHandle(resource,fileName) ;
		//对数据操作进行动态代理
		InvocationHandler proxUser = new ProxyUser(datahandle) ;
		datahandle = (DataHandle<User>)Proxy.newProxyInstance(proxUser.getClass().getClassLoader(), 
						datahandle.getClass().getInterfaces(),proxUser) ;
		return datahandle;
	
	}

}
