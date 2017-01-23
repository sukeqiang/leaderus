package myframework.dao;


public class AbstractDao<T> {

	public boolean createDomainObj(T o) {
		return true;
	}
	
	public boolean deleteDomainObj(T o) {
		return true;
	}
	
}
