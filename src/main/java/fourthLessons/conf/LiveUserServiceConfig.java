package fourthLessons.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile(value = "liveConf")
@PropertySource("classpath:dataSource.properties")
@ImportResource("classpath:dataSource.xml")
@Configuration
public class LiveUserServiceConfig {

}
