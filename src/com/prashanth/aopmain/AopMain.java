package com.prashanth.aopmain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prashanth.service.FactoryService;
import com.prashanth.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
		//shapeService.getCircle(); //.setName("Circle with radius 10 cm");
		//System.out.println(shapeService.getCircle().getName());
		//System.out.println(shapeService.getTriangle().getName());
		
		//For implementing the Factory service and understanding the AOP Proxies
		FactoryService factoryService = new FactoryService();
		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
		shapeService.getCircle();
	}

}