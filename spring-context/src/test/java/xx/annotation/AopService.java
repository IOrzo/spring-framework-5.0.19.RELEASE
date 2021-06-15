package xx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xie yuan bing
 * @date 2021-04-02 15:03
 */
@Service
public class AopService {

//	@Autowired
	private DependencySetter dependencySetter;

	public void service() {
		System.out.println("正常业务逻辑");
	}

	public DependencySetter getDependencySetter() {
		return dependencySetter;
	}

	public void setDependencySetter(DependencySetter dependencySetter) {
		this.dependencySetter = dependencySetter;
	}
}
