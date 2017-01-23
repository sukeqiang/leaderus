package userservice.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import userservice.interfaces.Resource;

public class FileSystemResource implements Resource {

	private final String filename ;
	
	public FileSystemResource(String filename) {
		this.filename = filename;
	}
	
	public InputStream getInputStream() throws IOException {
		return new FileInputStream(new File(this.filename));
	}
}
