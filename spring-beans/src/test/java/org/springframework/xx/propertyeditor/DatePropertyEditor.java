package org.springframework.xx.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义属性编辑器
 * @author xie yuan bing
 * @date 2021-01-20 09:16
 * @description
 */
public class DatePropertyEditor extends PropertyEditorSupport {

	private String datePattern = "yyyy/MM/dd";

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat sdf = new SimpleDateFormat(getDatePattern());
		try {
			Date dateValue = sdf.parse(text);
			setValue(dateValue);
		} catch (ParseException e) {
			e.printStackTrace();
			setValue(null);
		}
	}

	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
}
