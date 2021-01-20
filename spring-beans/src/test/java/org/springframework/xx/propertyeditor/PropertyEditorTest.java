package org.springframework.xx.propertyeditor;

import org.junit.Test;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.beans.PropertyEditor;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xie yuan bing
 * @date 2021-01-20 09:32
 * @description
 */
public class PropertyEditorTest {


	@Test
	public void testCustomPropertyEditor() {
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("xx/beanFactoryTest-property-editor.xml"));
		CustomEditorConfigurer configurer = new CustomEditorConfigurer();
		Map<Class<?>, Class<? extends PropertyEditor>> customEditor = new HashMap<>();
		customEditor.put(Date.class, DatePropertyEditor.class);
		configurer.setCustomEditors(customEditor);
		configurer.postProcessBeanFactory(beanFactory);
		DateFoo dateFoo = beanFactory.getBean("dateFoo", DateFoo.class);
		System.out.println(dateFoo);
	}

	/**
	 * 2.0之后，比较提倡使用propertyEditorRegistrars属性来指定自定义的PropertyEditor
	 */
	@Test
	public void testCustomPropertyEditorV2() {
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("xx/beanFactoryTest-property-editor.xml"));
		CustomEditorConfigurer configurer = new CustomEditorConfigurer();
		configurer.setPropertyEditorRegistrars(new PropertyEditorRegistrar[]{new DatePropertyEditorRegistrar()});
		configurer.postProcessBeanFactory(beanFactory);
		DateFoo dateFoo = beanFactory.getBean("dateFoo", DateFoo.class);
		System.out.println(dateFoo);
	}
}
