package xx.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 注解相关工具类测试和使用
 * @author xie yuan bing
 * @date 2021-07-02 16:52
 */
public class SimpleMetadataReaderFactoryTest {

	@Test
	public void testAnnotation() throws IOException {
		SimpleMetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();
		MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(PrintAspect.class.getName());
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		// 获取类上的注解
		System.out.println(annotationMetadata.getAnnotationTypes());
		// 获取类上注解的元注解
		System.out.println(annotationMetadata.getMetaAnnotationTypes(Component.class.getName()));
		// 获取注解上的方法
		System.out.println(annotationMetadata.getAnnotatedMethods(Pointcut.class.getName()));
		// 获取注解里的属性
		System.out.println(annotationMetadata.getAnnotationAttributes(Aspect.class.getName()));
		// 获取注解里的属性，值是列表的形式
		System.out.println(annotationMetadata.getAllAnnotationAttributes(Aspect.class.getName()));
	}
}
