package org.springframework.xx;

/**
 * @author xie yuan bing
 * @date 2020-11-04 12:26
 * @description
 */
public class TestC {

	private TestA testA;

	public TestC() {

	}

	public TestC(TestA testA) {
		this.testA = testA;
	}

	public void c() {
		testA.a();
	}

	public TestA getTestA() {
		return testA;
	}

	public void setTestA(TestA testA) {
		this.testA = testA;
	}
}
