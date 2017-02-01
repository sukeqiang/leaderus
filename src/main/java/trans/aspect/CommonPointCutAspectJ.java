package trans.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommonPointCutAspectJ {

	@Pointcut("execution(* trans.service.*Service.*(..))")
	public void transHandler(){}
}
