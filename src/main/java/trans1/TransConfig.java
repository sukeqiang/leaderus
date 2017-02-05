package trans1;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource("classpath:dataSource.xml")
@ComponentScan("trans1")
@EnableTransactionManagement
public class TransConfig {
	@Bean
	public PlatformTransactionManager getTransactionManager(DataSource live_datasource) {
		DataSourceTransactionManager tx = new DataSourceTransactionManager();
		tx.setDataSource(live_datasource);
		return tx;
	}
}
