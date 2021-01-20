package xx.annotation;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class AnnotationXmlBeanFactoryTest {

	@Test
	public void testBeanFactory() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("/xx/beanFactoryTest-annotation.xml"));
		AnnotationEntityTest entity = beanFactory.getBean("annotationEntityTest", AnnotationEntityTest.class);
		System.out.println(entity);
	}

}