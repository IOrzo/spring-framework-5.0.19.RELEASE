package org.springframework.xx;

/**
 * @author xie yuan bing
 * @date 2020-11-04 12:26
 * @description
 */
public class TestB {

	private TestC testC;

	public TestB() {

	}

	public TestB(TestC testC) {
		this.testC = testC;
	}

	public void b() {
		testC.c();
	}

	public TestC getTestC() {
		return testC;
	}

	public void setTestC(TestC testC) {
		this.testC = testC;
	}
}
