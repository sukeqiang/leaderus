package trans.support;

import java.sql.Connection;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component("dstm")
public class DataSourceTransactionManager {
	
	@Resource(name = "live_datasource")
	private DataSource datasource;
	
	public Connection getConnection() {
		return TransactionSynchronizationManager.getResource();
	}
	
	public void doSuspend() {
		TransactionSynchronizationManager.doUnbindResource();
	}
	
	public void doBegin() {
		try {
			TransactionSynchronizationManager.bindResource(datasource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
