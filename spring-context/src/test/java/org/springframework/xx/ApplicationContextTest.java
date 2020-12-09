package org.springframework.xx;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author xie yuan bing
 * @date 2020-11-09 11:25
 * @description
 */
public class ApplicationContextTest {

	@Test
	public void testApplicationContext() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/xx/beanFactoryTest.xml");
		MyTestBean myTestBean = (MyTestBean) ac.getBean("myTestBean");
		Assert.assertEquals("hello world", myTestBean.getStr());
	}

	@Test
	public void testBeanFactoryProcessor() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/xx/beanFactoryTest.xml");
		SimplePostProcessor simpleBean = (SimplePostProcessor) ac.getBean("simpleBean");
		System.out.println(simpleBean);
	}
}
