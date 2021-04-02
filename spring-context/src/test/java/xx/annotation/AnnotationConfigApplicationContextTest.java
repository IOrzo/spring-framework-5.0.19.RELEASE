package xx.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xie yuan bing
 * @date 2021-04-01 10:10
 */
public class AnnotationConfigApplicationContextTest {

	@Test
	public void testAnnotationConfigApplicationContext() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("xx.annotation");
		AnnotationEntityTest entity = (AnnotationEntityTest) context.getBean("annotationEntityTest");
		System.out.println(entity);
	}

	/**
	 * AOP流程
	 */
	@Test
	public void testAnnotationAop() {
		AopConfigApplicationContext context = new AopConfigApplicationContext("xx.annotation");
		AopService aopService = (AopService) context.getBean("aopService");
		aopService.service();
	}
}
