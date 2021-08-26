package xx.annotation;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.core.io.ClassPathResource;

public class AnnotationXmlBeanFactoryTest {

	@Test
	public void testBeanFactory() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("/xx/beanFactoryTest-annotation.xml"));
		AnnotationEntityTest entity = beanFactory.getBean("annotationEntityTest", AnnotationEntityTest.class);
		System.out.println(entity);
	}

	/**
	 * AutowiredAnnotationBeanPostProcessor @Autowired @Value @Inject 注解处理器执行流程
	 * 1. 在 bean 实例化过后执行 MergedBeanDefinitionPostProcessor.postProcessMergedBeanDefinition() 指定的 bean definition
	 * 进行后置处理。找到有相关注解的元素，包装成注入元数据，里面包括注入的 Field、Method、Constructor
	 * 2. 执行 InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation() 实例化过后的后置处理器，当前处理器为空操作
	 * 3. 执行 InstantiationAwareBeanPostProcessor.postProcessPropertyValues() 对有注解的元素进行注入
	 * 4. 注入完成过后，进行后续操作，对剩余属性执行赋值
	 */
	@Test
	public void testAnnotation() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("/xx/beanFactoryTest-annotation.xml"));
		// 先初始化 BeanPostProcessor, @Autowired 注解后置处理器，在 bean 实例化过后调用属性后置处理器对 bean 进行注入
		((ConfigurableBeanFactory)beanFactory).addBeanPostProcessor((BeanPostProcessor) beanFactory.getBean(AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME));
		DependencySetter dependencySetter = beanFactory.getBean("dependencySetter", DependencySetter.class);
		dependencySetter.getAopService().service();
	}

}