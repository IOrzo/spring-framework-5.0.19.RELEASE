package xx.annotation;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.DebugInterceptor;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.lang.Nullable;
import org.springframework.tests.sample.beans.ITestBean;

import java.lang.reflect.Method;

/**
 * 以编程方式创建 AOP 代理ProxyFactory
 * @author xie yuan bing
 * @date 2021-11-26 15:14
 */
public class AopWithoutIocTest {

	/**
	 * 无论您创建 AOP 代理，您都可以通过使用 org.springframework.aop.framework.Advised 接口来操作它们 。
	 * 任何 AOP 代理都可以转换到这个接口，不管它实现了哪些其他接口。
	 */

	/**
	 * 使用 Spring 以编程方式创建 AOP 代理很容易。这使您可以在不依赖 Spring IoC 的情况下使用 Spring AOP。
	 * 目标对象实现的接口被自动代理。以下清单显示了为目标对象创建代理，具有一个拦截器和一个顾问
	 */
	public static void main(String[] args) {
		ProxyFactory factory = new ProxyFactory(new MyBusinessInterfaceImpl());
		factory.addAdvice(new DebugInterceptor());
		factory.addAdvice(new PerformanceMonitorInterceptor());
		factory.addAdvisor(new TestBeanAdvisor());
		MyBusinessInterface tb = (MyBusinessInterface) factory.getProxy();
		tb.service();
		tb.service();
		Advised advised = (Advised) tb;
		System.out.println(advised.getAdvisors().length);
		System.out.println(advised.toProxyConfigString());
	}


	@SuppressWarnings("serial")
	static class TestBeanAdvisor extends StaticMethodMatcherPointcutAdvisor {

		public int count;

		public TestBeanAdvisor() {
			setAdvice(new MethodBeforeAdvice() {
				@Override
				public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
					++count;
					System.out.println("TestBeanAdvisor:" + count);
				}
			});
		}

		@Override
		public boolean matches(Method method, @Nullable Class<?> targetClass) {
			return MyBusinessInterface.class.isAssignableFrom(targetClass);
		}

	}
}
