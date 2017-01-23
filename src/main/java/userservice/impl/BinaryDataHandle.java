package userservice.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import userservice.bean.User;
import userservice.bean.UserSession;
import userservice.interfaces.DataHandle;
import userservice.interfaces.Resource;

public class BinaryDataHandle implements DataHandle<User> {
	
	Resource resource ;
	String fileName ;
	
	public BinaryDataHandle(Resource resource,String fileName) {
		this.resource = resource ;
		this.fileName = fileName ;
	}
	
	public boolean createUser(User t) {
		System.out.println("����û���" + t.getUserName() + " " + this.getClass().getSimpleName());
		return true ;
	}

	public boolean deleteUser(long userId) {
		System.out.println("ɾ���û�id��" + userId + " " + this.getClass().getSimpleName());
		return true ;
	}

	public boolean disableUser(long userId) {
		System.out.println("�����û�id��" + userId + " " + this.getClass().getSimpleName());
		return true ; 
	}

	public List<User> queryUsers(String userNamePrex, boolean onlyValidUser) {
		List<User> users = new ArrayList<User>();
		System.out.println("ͨ���û�����" + userNamePrex + "onlyValidUser:" + Boolean.toString(onlyValidUser) + " " + this.getClass().getSimpleName());
		return users ; 
	
	}

	public UserSession login(String userName, String md5EncodedPassword) {
		UserSession session = new UserSession() ;
		session.setSessionId(UUID.randomUUID().toString());
		session.setUserId(000001);
		session.setUserName(userName);
		session.setValidSeconds(Short.parseShort("3"));
		session.setCreateTime(System.currentTimeMillis());
		return session;
	}
}
