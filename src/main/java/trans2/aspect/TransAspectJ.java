package trans2.aspect;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


@Component
@Aspect
public class TransAspectJ {

	protected static Log logger = LogFactory.getLog(TransAspectJ.class);
		
	public TransAspectJ(){
		logger.info("init TransAspectJ class");
	}
	
	@Resource(name = "dstm")
	private DataSourceTransactionManager dstm;
	
	@Around("trans2.aspect.CommonPointCutAspectJ.transHandler()")
	public void invokeWithinTransaction(ProceedingJoinPoint pjp) throws Throwable{
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		definition.setTimeout(300);
		TransactionStatus status = dstm.getTransaction(definition);
		try{
			pjp.proceed();
		}catch(Throwable ex) {
			ex.printStackTrace();
			status.setRollbackOnly();
		}
		dstm.commit(status);
	}
}
