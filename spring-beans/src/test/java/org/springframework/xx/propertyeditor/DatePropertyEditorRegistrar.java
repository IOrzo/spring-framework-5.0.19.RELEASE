package org.springframework.xx.propertyeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.util.Date;

/**
 * @author xie yuan bing
 * @date 2021-01-20 10:36
 * @description
 */
public class DatePropertyEditorRegistrar implements PropertyEditorRegistrar {

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, new DatePropertyEditor());
	}
}
