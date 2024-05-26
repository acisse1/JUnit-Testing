package com.promineotech;

public class Main {

	public static void main(String[] args) {
		
		TestDemo testDemo = new TestDemo();

		String str = "Hello";
		
		System.out.println(str instanceof String);
		
		System.out.println(str.getClass().getSimpleName());
		
		System.out.println(testDemo.stringConcat("Hello", "World"));
		
	}

}
