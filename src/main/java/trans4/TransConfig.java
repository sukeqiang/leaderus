package trans4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.NoRollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import trans.test.CustomTransException;

@Configuration
@ComponentScan(basePackages = "trans4")
@ImportResource("classpath:dataSource.xml")
@EnableAspectJAutoProxy
public class TransConfig {

	@Resource(name = "live_datasource")
	private DataSource live_datasource;
	
	@Bean
	public PlatformTransactionManager getTransactionManager() {
		DataSourceTransactionManager tx = new DataSourceTransactionManager();
		tx.setDataSource(live_datasource);
		return tx;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(DataSource live_datasource) {
		return new JdbcTemplate(live_datasource);
	}
	
	@Bean
	public AspectJExpressionPointcutAdvisor transactionAdvisor() {
	    AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
	    advisor.setAdvice(transactionInterceptor());
	    advisor.setExpression("execution(* trans4.*.*(..)) ");
	    return advisor;
	}
	
	@Bean
	public TransactionInterceptor transactionInterceptor() {
	    return new TransactionInterceptor(getTransactionManager(), transactionAttributeSource());
	}
	
	@Bean
	public NameMatchTransactionAttributeSource transactionAttributeSource() {
	    NameMatchTransactionAttributeSource tas = new NameMatchTransactionAttributeSource();
	    
	    RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
	    readOnlyTx.setReadOnly(true);

	    RuleBasedTransactionAttribute requredTx = new RuleBasedTransactionAttribute(TransactionDefinition.PROPAGATION_REQUIRED, 
	    		Collections.singletonList(new NoRollbackRuleAttribute(CustomTransException.class)));

	    Map<String, TransactionAttribute> txMaps = new HashMap<>();
	    txMaps.put("get*", readOnlyTx);
	    txMaps.put("add*", requredTx);
	    tas.setNameMap(txMaps);
	    return tas;
	}
}
