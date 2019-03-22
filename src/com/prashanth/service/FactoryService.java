package com.prashanth.service;

import com.prashanth.model.Circle;
import com.prashanth.model.Triangle;

//For implementing the Factory service and understanding the AOP Proxies
public class FactoryService {
	
	public Object getBean(String beanType) {
		if(beanType.equals("shapeService")) return new ShapeServiceProxy();
		if(beanType.equals("circle")) return new Circle();
		if(beanType.equals("triangle")) return new Triangle();
		return null;
	}

}