package xx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xie yuan bing
 * @date 2021-05-13 11:32
 */
@Component
public class DependencySetter {

	@Autowired
	private AopService aopService;

	public void service() {
		System.out.println("DependencySetter 正常业务逻辑");
	}

	public AopService getAopService() {
		return aopService;
	}

	public void setAopService(AopService aopService) {
		this.aopService = aopService;
	}
}
