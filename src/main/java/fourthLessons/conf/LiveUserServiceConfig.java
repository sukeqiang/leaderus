package fourthLessons.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Profile(value = "liveConf")
@ImportResource("classpath:dataSource.xml")
@Configuration
public class LiveUserServiceConfig {
}
