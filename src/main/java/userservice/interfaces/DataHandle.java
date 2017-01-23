package userservice.interfaces;

import java.util.List;

import userservice.bean.UserSession;

public interface DataHandle<T> {
	
	public boolean createUser(T t) ;

	public boolean deleteUser(long userId) ;

	public boolean disableUser(long userId) ;

	public List<T> queryUsers(String userNamePrex, boolean onlyValidUser) ;

	public UserSession login(String userName, String md5EncodedPassword) ;
}
