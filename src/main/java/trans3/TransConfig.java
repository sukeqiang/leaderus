package trans3;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "trans3")
@ImportResource("classpath:dataSource.xml")
@EnableTransactionManagement(proxyTargetClass = true)
public class TransConfig {

	@Bean
	public PlatformTransactionManager getTransactionManager(DataSource live_datasource) {
		DataSourceTransactionManager tx = new DataSourceTransactionManager();
		tx.setDataSource(live_datasource);
		return tx;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(DataSource live_datasource) {
		return new JdbcTemplate(live_datasource);
	}
}
