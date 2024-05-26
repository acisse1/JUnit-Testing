package com.promineotech;

import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class TestDemo {
	
	public int addPositive (int a, int b) {
		
		if (a > 0 && b > 0) {
			return a + b;
		}
		
		else {
			throw new IllegalArgumentException ("Both parameters must be positive!.");
		}
	}
	
	// method for part 3.
	
	public String stringConcat (String a, String b) {
		
		return a + " " + b;
	}
	
	// method for part 4.
	
	@VisibleForTesting
	public int getRandomInt () {
		
		Random random = new Random();
		
		return random.nextInt(10) + 1;
	}
	
	public int randomNumberSquared () {
		
		int num = getRandomInt();
		
		return num * num;
	}

}
