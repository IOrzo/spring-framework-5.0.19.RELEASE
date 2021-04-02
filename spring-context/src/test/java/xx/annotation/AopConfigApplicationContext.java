package xx.annotation;

import org.springframework.aop.config.AopConfigUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xie yuan bing
 * @date 2021-04-02 15:22
 */
public class AopConfigApplicationContext extends AnnotationConfigApplicationContext {

	public AopConfigApplicationContext(String... basePackages) {
		super();
		// 注入AOP功能
		AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(this);
		this.scan(basePackages);
		this.refresh();
	}


}
