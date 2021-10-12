package xx.annotation;

import org.springframework.stereotype.Component;

/**
 * @author xie yuan bing
 * @date 2021-10-12 10:33
 */
@Component
public class AllAspectService {


	public void exec() {
		System.out.println("AllAspectService 执行");
	}

	/** ---------- 5.0.19 执行顺序 ----------**/
	/**
	 * Around  before AllAspect
	 * Before  AllAspect
	 * AllAspectService 执行
	 * Around  after AllAspect
	 * After  AllAspect
	 * AfterReturning  AllAspect
	 */
}
