package trans1;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import trans.test.ThreadLocalUtil;
import trans1.TransConfig;
import trans1.MyLessionService;

public class Trans1 {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TransConfig.class);
		IService service = (IService)ctx.getBean("MyLessionService");
		service.addLession("mick", "13.00");
		// ThreadLocalUtil.dumphreadLocals();
		// service.queryLession("mick");
		// ThreadLocalUtil.dumphreadLocals();
		// status.setRollbackOnly();
		ThreadLocalUtil.dumphreadLocals();
		ctx.close();
		// ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		// for (int i = 0; i < 3; i++) {
		// final int index = i;
		// fixedThreadPool.execute(new Runnable() {
		// public void run() {
		// try {
		// TransactionStatus status = tx.getTransaction(def);
		// ThreadLocalUtil.dumphreadLocals();
		// service.addLession("mick"+index, "13.00");
		// ThreadLocalUtil.dumphreadLocals();
		// tx.commit(status);
		// ThreadLocalUtil.dumphreadLocals();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// }
		// });
		// }
	}
}
