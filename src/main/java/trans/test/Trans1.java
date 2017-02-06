package trans.test;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import trans.conf.TransConfig;
import trans.service.MyLessionService;

public class Trans1 {

	public static void main(String[] args){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TransConfig.class);
//		PlatformTransactionManager tx = ctx.getBean(PlatformTransactionManager.class);
//		ThreadLocalUtil.dumphreadLocals();
//		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//		def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
//		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//		def.setTimeout(300);
//		ThreadLocalUtil.dumphreadLocals();
		MyLessionService service = ctx.getBean(MyLessionService.class);
		service.addLession("mick", "13.00");
//		 TransactionStatus status = tx.getTransaction(def);
//		 ThreadLocalUtil.dumphreadLocals();
//		 try {
//			service.addLession("mick", "13.00");
//		} catch (CustomTransException e) {
//			e.printStackTrace();
//			status.setRollbackOnly();
//		}
//		 tx.commit(status);
//		 ThreadLocalUtil.dumphreadLocals();
//		 service.queryLession("mick");
//		 ThreadLocalUtil.dumphreadLocals();
//		 status.setRollbackOnly();
		 
//		 ThreadLocalUtil.dumphreadLocals();
		
		 ctx.close();

//		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//		for (int i = 0; i < 3; i++) {
//			final int index = i;
//			fixedThreadPool.execute(new Runnable() {
//				public void run() {
//					 try {
//						 TransactionStatus status = tx.getTransaction(def);
//						 ThreadLocalUtil.dumphreadLocals();
//						 service.addLession("mick"+index, "13.00");
//						 ThreadLocalUtil.dumphreadLocals();
//						 tx.commit(status);
//						 ThreadLocalUtil.dumphreadLocals();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}
	}
}
