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

@Profile(value = "testConf")
@Configuration
@PropertySource(value = "classpath:test_conf.properties" )
public class TestUserServiceConfig {

	@Autowired
	@Value("${fileName}")
	private String fileName ;
	
	@Bean
	public DataHandle<User> dataHandle() {	
		return new XmlDataResolver()
				.setNext(new JsonDataResolver()
				.setNext(new BinaryDataResolver()))
				.resolver(fileName) ;
	}
}
