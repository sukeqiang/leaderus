package trans1;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import trans.test.ThreadLocalUtil;
import trans1.TransConfig;
import trans1.MyLessionService;

public class Trans2 {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TransConfig.class);
		MyLessionService service = ctx.getBean(MyLessionService.class);
		
		PlatformTransactionManager tx = ctx.getBean(PlatformTransactionManager.class);
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		def.setTimeout(300);
		TransactionStatus status1 = tx.getTransaction(def);
		service.addLession("mick", "13.00");
		
		def = new DefaultTransactionDefinition();
		def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus status2 = tx.getTransaction(def);
		service.queryLession("mick");
		tx.commit(status2);
		tx.commit(status1);
		ctx.close();
	}
}
