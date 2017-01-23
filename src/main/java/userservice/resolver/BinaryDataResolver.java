package userservice.resolver;


import userservice.bean.User;
import userservice.factory.BinaryDataFactory;
import userservice.factory.HandleFactory;
import userservice.interfaces.DataHandle;

public class BinaryDataResolver extends ChainResolver<DataHandle<User>> {

	@Override
	public HandleFactory<DataHandle<User>> supportsDataFactory(String fileName) {
		return new BinaryDataFactory();
	}
}
