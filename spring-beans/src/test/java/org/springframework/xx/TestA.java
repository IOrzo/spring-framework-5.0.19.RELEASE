package org.springframework.xx;

/**
 * @author xie yuan bing
 * @date 2020-11-04 12:26
 * @description
 */
public class TestA {

	private TestB testB;

	public TestA() {

	}

	public TestA(TestB testB) {
		this.testB = testB;
	}

	public void a() {
		testB.b();
	}

	public TestB getTestB() {
		return testB;
	}

	public void setTestB(TestB testB) {
		this.testB = testB;
	}
}
