package trans.support;

import java.sql.Connection;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class TransactionSynchronizationManager {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionSynchronizationManager.class);
	
	private static final ThreadLocal<Connection> resources = new ThreadLocal<Connection>();
	
	public static Connection getResource() {
		return resources.get();
	}
	
	public static void doUnbindResource() {
		Connection conn = resources.get();
		if(conn != null) {
			resources.remove();
			logger.info("Unbind datasource from thread [" + Thread.currentThread().getName() + "]");
		}
	}
	
	public static void bindResource(DataSource datasource) throws Exception {
		Assert.notNull(datasource, "datasource must not be null");
		resources.set(datasource.getConnection());
		logger.info("Bound datasource [" + datasource.getClass().getSimpleName() + "] to thread [" + Thread.currentThread().getName() + "]");
	}
	
}
