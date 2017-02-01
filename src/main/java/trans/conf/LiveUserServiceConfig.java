package trans.conf;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Profile(value = "liveConf")
@ImportResource("classpath:dataSource.xml")
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true,exposeProxy=true)
@Configurable
public class LiveUserServiceConfig {
}
