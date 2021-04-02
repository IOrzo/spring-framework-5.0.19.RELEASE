package xx.annotation;

import org.springframework.stereotype.Service;

/**
 * @author xie yuan bing
 * @date 2021-04-02 15:03
 */
@Service
public class AopService {


	public void service() {
		System.out.println("正常业务逻辑");
	}
}
