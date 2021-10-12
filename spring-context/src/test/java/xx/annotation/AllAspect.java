package xx.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 所有切面注解执行流程
 * 执行流程与 Spring 版本号有关, 4 与 5 就有差异
 * 5 更符合逻辑一些，这里以 5 为例
 * 注意: 5 版本也有差异
 * @author xie yuan bing
 * @date 2021-10-12 10:30
 */
@Component
@Aspect
public class AllAspect {

	/* ---------- 5.0.19 5.1.11 之前执行顺序 ---------- */
	/**
	 * Around  before AllAspect
	 * Before  AllAspect
	 * AllAspectService 执行
	 * Around  after AllAspect
	 * After  AllAspect
	 * AfterReturning  AllAspect
	 */

	/* ---------- 5.2.15 执行顺序 ---------- */
	/**
	 * Around  before AllAspect
	 * Before  AllAspect
	 * AllAspectService 执行
	 * AfterReturning  AllAspect
	 * After  AllAspect
	 * Around  after AllAspect
	 */

	@Pointcut("execution(public void xx.annotation.AllAspectService.exec())")
	public void pointCut(){

	}

	@Around(value = "pointCut()")
	public void around(ProceedingJoinPoint pjp) {
		System.out.println("Around  before AllAspect");
		try {
			pjp.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		System.out.println("Around  after AllAspect");
	}

	@Before(value = "pointCut()")
	public void before(JoinPoint jp) {
		System.out.println("Before  AllAspect");
	}

	@After(value = "pointCut()")
	public void after() {
		System.out.println("After  AllAspect");
	}

	@AfterReturning(value = "pointCut()")
	public void afterReturning() {
		System.out.println("AfterReturning  AllAspect");
	}

	@AfterThrowing(value = "pointCut()", throwing = "e")
	public void afterThrowing(JoinPoint jp, Exception e) {
		System.out.println("AfterThrowing  AllAspect");
	}

}
