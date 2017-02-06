package trans2.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommonPointCutAspectJ {

	@Pointcut("execution(* trans2.service.*Service.*(..))")
	public void transHandler(){}
}
