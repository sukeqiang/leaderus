package userservice.resolver;

import org.apache.commons.lang.StringUtils;

import userservice.factory.ClasspathResourceFactory;
import userservice.factory.HandleFactory;
import userservice.interfaces.Resource;
import userservice.utils.Utils;

public class ClasspathResourceResolver extends ChainResolver<Resource> {

	@Override
	public HandleFactory<Resource> supportsDataFactory(String fileName) {
		if(StringUtils.startsWith(fileName, Utils.CLASSPATH_URL_PREFIX)){
			return new ClasspathResourceFactory() ;
		}
		return null;
	}

}
