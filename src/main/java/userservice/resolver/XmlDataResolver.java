package userservice.resolver;

import org.apache.commons.lang.StringUtils;

import userservice.bean.User;
import userservice.factory.HandleFactory;
import userservice.factory.XmlDataFactory;
import userservice.interfaces.DataHandle;
import userservice.utils.Utils;

public class XmlDataResolver extends ChainResolver<DataHandle<User>>  {

	@Override
	public HandleFactory<DataHandle<User>> supportsDataFactory(String fileName) {
		if(StringUtils.endsWith(fileName, Utils.XML_FILENAME_PREFIX)){
			return new XmlDataFactory() ;
		}
		return null;
	}

}
