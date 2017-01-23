package userservice.factory;

import userservice.impl.FileSystemResource;
import userservice.interfaces.Resource;

public class FilesystemResourceFactory extends HandleFactory<Resource> {

	@Override
	public Resource instance(String fileName) {
		return new FileSystemResource(fileName) ;
	}

}
