package com.prashanth.service;

import com.prashanth.aspect.LoggingAspect;
import com.prashanth.model.Circle;

//For implementing the Factory service and understanding the AOP Proxies
public class ShapeServiceProxy extends ShapeService {
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}