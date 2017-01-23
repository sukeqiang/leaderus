package userservice.factory;


public abstract class HandleFactory<T> {

	public abstract T instance(String fileName) ;
}
