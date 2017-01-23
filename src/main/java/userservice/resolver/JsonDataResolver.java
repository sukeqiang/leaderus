package userservice.resolver;

import org.apache.commons.lang.StringUtils;

import userservice.bean.User;
import userservice.factory.HandleFactory;
import userservice.factory.JsonDataFactory;
import userservice.interfaces.DataHandle;
import userservice.utils.Utils;

public class JsonDataResolver extends ChainResolver<DataHandle<User>> {

	@Override
	public HandleFactory<DataHandle<User>> supportsDataFactory(String fileName) {
		if(StringUtils.endsWith(fileName, Utils.JSON_FILENAME_PREFIX)){
			return new JsonDataFactory() ;
		}
		return null;
	}

}
