package org.springframework.xx.propertyeditor;

import java.util.Date;

/**
 * @author xie yuan bing
 * @date 2021-01-20 09:25
 * @description
 */
public class DateFoo {

	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "DateFoo{" +
				"date=" + date +
				'}';
	}
}
