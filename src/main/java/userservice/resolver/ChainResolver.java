package userservice.resolver;

import userservice.factory.HandleFactory;

public abstract class ChainResolver<V> {
	
	private ChainResolver<V> next ;
	
	public ChainResolver<V> setNext(ChainResolver<V> next) {
		this.next = next;
		return this ;
	}
	
	public final V resolver(String fileName) {
		HandleFactory<V> factory = this.supportsDataFactory(fileName) ;
		if(factory != null) {
			return factory.instance(fileName) ;
		}else{
			if(next != null ) {
				return next.resolver(fileName) ;
			}else{
				return  null ;
			}
		}
	}

	public abstract HandleFactory<V> supportsDataFactory(String fileName) ;

}
