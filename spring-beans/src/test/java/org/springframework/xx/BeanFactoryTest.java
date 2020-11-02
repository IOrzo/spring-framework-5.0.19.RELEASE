package org.springframework.xx;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {

	@Test
	public void testBeanFactory() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("/xx/beanFactoryTest.xml"));
		MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
		Assert.assertEquals("hello world", myTestBean.getStr());
	}
}