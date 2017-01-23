package userservice.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import userservice.interfaces.Resource;

public class ClassPathResource implements Resource {

	private Class<?> clazz;
	
	private final String path;
	
	private ClassLoader classLoader;
	
	public ClassPathResource(String path) {
		this.path = path ;
	}
	
	public InputStream getInputStream() throws IOException {
		InputStream is;
		if (this.clazz != null) {
			is = this.clazz.getResourceAsStream(this.path);
		}
		else if (this.classLoader != null) {
			is = this.classLoader.getResourceAsStream(this.path);
		}
		else {
			is = ClassLoader.getSystemResourceAsStream(this.path);
		}
		if (is == null) {
//			throw new FileNotFoundException(" cannot be opened because it does not exist");
		}
		return is;
	}

}
