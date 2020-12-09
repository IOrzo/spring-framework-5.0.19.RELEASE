package org.springframework.xx;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author xie yuan bing
 * @date 2020-11-06 15:07
 * @description
 */
public class CarFactoryBean implements FactoryBean<Car> {

	private String carInfo;

	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		String[] infos = carInfo.split(",");
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.valueOf(infos[1]));
		car.setPrice(Double.valueOf(infos[2]));
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
