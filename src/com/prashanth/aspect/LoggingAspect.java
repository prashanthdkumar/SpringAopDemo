package com.prashanth.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.prashanth.model.Circle;

@Aspect
public class LoggingAspect {

	//@Before("allGetters() && allCircleMethods()")
	@Before("allCircleMethods()")
	public void loggingAdvice(JoinPoint joinPoint) {
		//System.out.println(joinPoint.toString());
		//Circle circle =  (Circle) joinPoint.getTarget();
		//System.out.println(circle.getName());
	}
	
	@AfterReturning(pointcut="args(name)", returning="returnString")
	public void stringArgumentMethods(String name, Object returnString) {
		System.out.println("A method with String arguments has been called. The value is " + name + " with return value " + returnString);
	}
	
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void exceptionAdvice(String name, RuntimeException ex) {
		System.out.println("An exception has been thrown " + ex);
	}
	
	/*
	@Before("allGetters()")
	public void secondAdvice() {
		System.out.println("Second Advice executed");
	}
	*/
	
	//@Around("allGetters()")
	@Around("@annotation(com.prashanth.aspect.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnValue = null;
		try {
			System.out.println("Before Advice");
			returnValue = proceedingJoinPoint.proceed(); //This executes our target method.
			System.out.println("After Returning");
		} catch(Throwable e) {
			System.out.println("After Throwing");
		}
		System.out.println("After Finally");
		return returnValue;
	}
	
	public void loggingAdvice() {
		System.out.println("Logging from the advice");
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters(){}
	
	@Pointcut("within(com.prashanth.model.Circle)")
	public void allCircleMethods(){}
}