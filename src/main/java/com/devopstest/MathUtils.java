package com.devopstest;

public class MathUtils {
	
	public String calculateArea(double radius) {
	    double area = Math.PI * radius * radius;
	    String result = String.format("%.2f", area);
	    return result;
	  }

	public int add(int a, int b) {
		return a + b;
	}
	
	public int subtract(int a, int b) {
		return a - b;
	}
	
	public int multiply(int a, int b) {
		return a * b;
	}
	
	public int divide(int a, int b) {
		return a/b;
	}

}
