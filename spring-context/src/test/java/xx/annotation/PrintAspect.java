package xx.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author xie yuan bing
 * @date 2021-04-02 15:04
 */
@Component
@Aspect
public class PrintAspect {

	@Pointcut(value = "execution(public void xx.annotation.AopService.service())")
	public void printPointCut(){}


	@Before(value = "printPointCut()")
	public void print(JoinPoint joinPoint) {
		System.out.println("业务逻辑执行之前进行增强");
	}


	@AfterReturning(value = "printPointCut()", returning = "ret")
	public void print(Object ret) {
		System.out.println("业务逻辑执行之后进行增强");
	}
}
