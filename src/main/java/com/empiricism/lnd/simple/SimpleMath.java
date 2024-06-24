package com.empiricism.lnd.simple;

public class SimpleMath {
	
	public int add(int a , int b) {
		return a + b;
	}
	
	public double calculateCircleArea(double radius) {
		return radius*radius*Math.PI;
	}
	
	public double div(double a , double b) {
		if(b==0.0)
			throw new ArithmeticException("Division by 0 is undefined");
		else
			return a / b;
	}

}
