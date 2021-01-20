package xx.annotation;

import org.springframework.stereotype.Component;

/**
 * @author xie yuan bing
 * @date 2021-01-20 14:49
 * @description
 */
@Component
public class AnnotationEntityTest {

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AnnotationEntityTest{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
