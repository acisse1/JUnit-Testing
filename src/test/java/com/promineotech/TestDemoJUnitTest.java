package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import net.bytebuddy.asm.Advice.Argument;

class TestDemoJUnitTest {
	
	// Assignment part 1.
	
	private static TestDemo testDemo;
	

	@BeforeEach
	void setUp() throws Exception {
		
		testDemo = new TestDemo();
	}
	
	
	@ParameterizedTest
	@MethodSource("argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly (
			int a, int b, int expected, boolean expectException) {
		
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		
		else {
			assertThatThrownBy(() ->
				testDemo.addPositive(a, b))
				.isInstanceOf(IllegalArgumentException.class);
					
		}	
	}
	
	static Stream<Arguments> argumentsForAddPositive () {
		
		return Stream.of(
				Arguments.of(2, 5, 7, false),	// test two arguments positive
				Arguments.of(-1, 9, 8, true),	// test first argument negative
				Arguments.of(1, 9, 10, false),	// test two arguments positive
				Arguments.of(31, 9, 40, false),	// test two arguments positive
				Arguments.of(-5, -6, -11, true), //test two arguments negative	
				Arguments.of(10, -4, 6, true),	// test second argument negative
				Arguments.of(0, 0, 0, true),	// test two arguments zero
				Arguments.of(0, 4, 4, true),	// test first argument zero
				Arguments.of(10, 0, 10, true)	// test second argument zero
				//Arguments.of(1, 1, 2, true)		// test should fail
				);
	}
	
	// Assignment Part 2.
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly () {
		
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(1, 100)).isEqualTo(101);
		assertThat(testDemo.addPositive(25, 40)).isEqualTo(65);
		assertThat(testDemo.addPositive(200, 31)).isEqualTo(231);
	}
	
	// Assignment Part 3.
	
	@ParameterizedTest
	@MethodSource("argumentForStringConcat")
	void stringConcatParameterTest(String a, String b, String expected) {
		
		assertThat(testDemo.stringConcat(a, b)).isEqualTo(expected);
	}
	
	
	static Stream<Arguments> argumentForStringConcat () {
		
		return Stream.of(
				Arguments.of("Hello", "World", "Hello World"),
				Arguments.of("John", "Mc Cain", "John Mc Cain"),
				Arguments.of("United", "States", "United States"),
				Arguments.of("Welcome to", "promineoTech", "Welcome to promineoTech"),
				Arguments.of("Unit test", "is owesome", "Unit test is owesome")
				);
	}
	
	// Assignment Part 4.
	
	@Test
	void assertThatNumberSquaredIsCorrect () {
		
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	

}
