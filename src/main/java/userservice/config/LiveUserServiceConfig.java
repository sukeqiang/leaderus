package userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import userservice.bean.User;
import userservice.interfaces.DataHandle;
import userservice.resolver.BinaryDataResolver;
import userservice.resolver.JsonDataResolver;
import userservice.resolver.XmlDataResolver;
import userservice.service.UserService;

@Profile(value = "liveConf")
@Configuration
@PropertySource(value = "classpath:live_conf.properties" )
public class LiveUserServiceConfig {

	@Autowired
	@Value("${fileName}")
	private String fileName ;
	
	@Bean
	public DataHandle<User> dataHandle() {	
		//设置责任链条并进行处理
		return new XmlDataResolver()
				.setNext(new JsonDataResolver()
				.setNext(new BinaryDataResolver()))
				.resolver(fileName) ;
	}
}
