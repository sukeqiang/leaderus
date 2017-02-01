package trans.aspect;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import trans.support.DataSourceTransactionManager;

@Component
@Aspect
public class TransAspectJ {

	private static final Logger logger = LoggerFactory.getLogger(TransAspectJ.class);
		
	public TransAspectJ(){
		logger.info("init TransAspectJ class");
	}
	
	@Resource(name = "dstm")
	private DataSourceTransactionManager dstm;
	
	@Around("trans.aspect.CommonPointCutAspectJ.transHandler()")
	public void initJdbc(ProceedingJoinPoint pjp) throws Throwable {
		dstm.doBegin();
		pjp.proceed();
	}
	
	@Before("execution(* trans.service.*Service.query*(..))")
	public void noTrans(JoinPoint jp) {
		try {
			if(!dstm.getConnection().getAutoCommit()) {
				dstm.getConnection().setAutoCommit(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Before("execution(* trans.service.*Service.save*(..)) "
			+ "|| execution(* trans.service.*Service.create*(..)) "
			+ "|| execution(* trans.service.*Service.update*(..)) "
			+ "|| execution(* trans.service.*Service.delete*(..))")
	public void doBegin(JoinPoint jp) {
		try {
			if(dstm.getConnection().getAutoCommit()) {
				dstm.getConnection().setAutoCommit(false);
				logger.info("open JDBC Connection for transaction to thread [" + Thread.currentThread().getName() + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@AfterThrowing(throwing = "ex",value = "trans.aspect.CommonPointCutAspectJ.transHandler()")
	public void rollback(RuntimeException ex) {
		ex.printStackTrace();
		Connection conn = dstm.getConnection();
		if(conn!= null) {
			try {
				if(!conn.getAutoCommit()) {
					logger.info("transaction rollback to thread [" + Thread.currentThread().getName() + "]");
					conn.rollback();
				}
				if(!conn.isClosed()) {
					conn.close();
				}
				dstm.doSuspend();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@AfterReturning("trans.aspect.CommonPointCutAspectJ.transHandler()")
	public void commit(JoinPoint jp) {
		Connection conn = dstm.getConnection();
		try {
			if(conn != null) {
				if(!conn.getAutoCommit()){
					logger.info("transaction commit!");
					conn.commit();
				}
				if(!conn.isClosed()) {
					conn.close();
				}
				dstm.doSuspend();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
