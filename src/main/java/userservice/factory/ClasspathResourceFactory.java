package userservice.factory;

import userservice.impl.ClassPathResource;
import userservice.interfaces.Resource;

public class ClasspathResourceFactory  extends HandleFactory<Resource> {

	@Override
	public Resource instance(String fileName) {
		return new ClassPathResource(fileName);
	}

}
