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

	/**
	 * 表示通过setter注入方式构成的循环依赖。对于setter注人造成的依赖是通过Spring 容器提前暴露刚完成构造器注人但未完成其他步骤(如setter注人)的bean来完成的，而且只能解
	 * 决单例作用域的bean循环依赖。通过提前暴露一个单例工厂方法，从而使其他bean能引用到该bean
	 * 可以通过"setAllowCircularReferences(false);"来禁用循环引用。
	 * @throws Throwable
	 */
	@Test
	public void testBeanFactoryConstructorSetter() throws Throwable {
		try {
			BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("/xx/beanFactoryTest-constructor-setter.xml"));
			MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
			TestA testA = (TestA) beanFactory.getBean("testA");
			CarFactoryBean carFactoryBean = (CarFactoryBean) beanFactory.getBean("&car");
			Car car = (Car) beanFactory.getBean("car");
			System.out.println("--- end ---");
		} catch (Exception e) {
			// 因为要在创建testC是抛出
//			Throwable cause = e.getCause().getCause().getCause();
			throw e;
		}
	}

	/**
	 * 测试构造器循环依赖
	 */
	@Test
	public void testBeanFactoryConstructorCircle() throws Throwable {
		/**
		 * Spring容器创建“testA" bean， 首先去“当前创建bean池”查找是否当前bean正在
		 * 创建，如果没发现，则继续准备其需要的构造器参数“testB”， 并将“testA" 标识符
		 * 放到“当前创建bean池”。
		 * Spring容器创建“testB” bean， 首先去“当前创建bean池”查找是否当前bean正在
		 * 创建，如果没发现，则继续准备其需要的构造器参数“testC”， 并将“testB” 标识符
		 * 放到“当前创建bean池”。
		 * Spring容器创建“testC" bean,首先去“当前创建bean池”查找是否当前bean正在
		 * 创建，如果没发现，则继续准备其需要的构造器参数“testA”, 并将“testC" 标识符
		 * 放到“当前创建bean池”
		 * 到此为止Spring容器要去创建“testA” bean, 发现该bean标识符在“ 当前创建bean
		 * 池”中，因为表示循环依赖，抛出BeanCurrentlyInCreationException。
		 */
		try {
			BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("/xx/beanFactoryTest-constructor-circle.xml"));
			TestA testA = (TestA) beanFactory.getBean("testA");
		} catch (Exception e) {
			// 因为要在创建testC是抛出
			Throwable cause = e.getCause().getCause().getCause();
			throw cause;
		}
	}

	/**
	 * 对于“prototype”作用域bean, Spring 容器无法完成依赖注人，
	 * 因为Spring容器不进行缓存“prototype"作用域的bean,因此无法提前暴露-一个创建中的bean。
	 * @throws Throwable
	 */
	@Test
	public void testBeanFactoryConstructorPrototype() throws Throwable {
		try {
			BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("/xx/beanFactoryTest-constructor-prototype.xml"));
			TestA testA = (TestA) beanFactory.getBean("testA");
		} catch (Exception e) {
			// 因为要在创建testC是抛出
			Throwable cause = e.getCause().getCause().getCause();
			throw cause;
		}
	}
}