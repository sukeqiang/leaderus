package userservice.resolver;

import org.apache.commons.lang.StringUtils;

import userservice.factory.HandleFactory;
import userservice.factory.FilesystemResourceFactory;
import userservice.interfaces.Resource;
import userservice.utils.Utils;

public class FilesystemResourceResolver extends ChainResolver<Resource> {

	@Override
	public HandleFactory<Resource> supportsDataFactory(String fileName) {
		if(StringUtils.startsWith(fileName, Utils.FILE_URL_PREFIX)){
			return new FilesystemResourceFactory() ;
		}
		return null;
	}

}
