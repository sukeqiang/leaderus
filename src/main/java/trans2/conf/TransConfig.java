package trans2.conf;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan(basePackages = "trans2")
@ImportResource("classpath:dataSource.xml")
@EnableAspectJAutoProxy(proxyTargetClass=true,exposeProxy=true)
public class TransConfig {

	@Bean(name = "dstm")
	public PlatformTransactionManager getTransactionManager(DataSource live_datasource) {
		DataSourceTransactionManager tx = new DataSourceTransactionManager();
		tx.setDataSource(live_datasource);
		return tx;
	}
}
