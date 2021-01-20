package org.springframework.xx;

import org.junit.Test;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

/**
 * @author xie yuan bing
 * @date 2021-01-15 14:33
 * @description
 */
public class MyAnnotationMetadataTests {

	@Test
	public void standardAnnotationMetadata() {
		// 内部类
		System.out.println("-------测试类元数据--------");
		System.out.println("-------第一个结果: 类是否是独立的: 如顶层类、静态内部类--------");
		System.out.println("-------第二个结果: 基础类是否是封闭类: 如内部类、嵌套类、方法中类--------");
		AnnotationMetadata metadata = new StandardAnnotationMetadata(MyAnnotationMetadataTests.class);
		System.out.println("-------MyAnnotationMetadataTests 顶层类--------");
		System.out.println(metadata.isIndependent());
		System.out.println(metadata.hasEnclosingClass());

		System.out.println("-------PrivateInnerClass 顶层类--------");
		AnnotationMetadata metadata2 = new StandardAnnotationMetadata(PrivateInnerClass.class);
		System.out.println(metadata2.isIndependent());
		System.out.println(metadata2.hasEnclosingClass());

		System.out.println("-------PrivateInnerClass.InnerClass 内部类--------");
		AnnotationMetadata metadata6 = new StandardAnnotationMetadata(PrivateInnerClass.InnerClass.class);
		System.out.println(metadata6.isIndependent());
		System.out.println(metadata6.hasEnclosingClass());

		System.out.println("-------StaticClass.InnerStaticClass 静态内部类--------");
		AnnotationMetadata metadata5 = new StandardAnnotationMetadata(StaticClass.InnerStaticClass.class);
		System.out.println(metadata5.isIndependent());
		System.out.println(metadata5.hasEnclosingClass());

		System.out.println("-------MyAnnotationMetadataTests.MyInnerClass 内部类--------");
		AnnotationMetadata metadata4 = new StandardAnnotationMetadata(MyInnerClass.class);
		System.out.println(metadata4.isIndependent());
		System.out.println(metadata4.hasEnclosingClass());


		MethodClassOuter methodClassOuter = new MethodClassOuter();
		methodClassOuter.test();



	}


	public class MyInnerClass {

	}


}

class StaticClass {

	static class InnerStaticClass {

	}
}

class PrivateInnerClass {

	public class InnerClass {

	}
}


class MethodClassOuter {

	public void test() {
		class MethodLocal {
			private String username = "xx";

			public String getUsername() {
				return this.username;
			}
		}
		System.out.println(new MethodLocal().getUsername());
	}
}
