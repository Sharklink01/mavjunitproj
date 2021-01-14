package com.devopstest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

class MathUtilsTest {
	
	MathUtils mathUtils; //created member variable
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	static void beforeallinit() {
		System.out.print("This needs to run before all. ");
	}
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
	}
	
	@AfterEach
	void cleanup() {
		System.out.print("Cleaning up...");
	}
	

	@RepeatedTest(2)
	@DisplayName("Testing circle area method.")
	@Tag("Circle")
	void testCalculateArea() {
		String expected = "153.94";
		String actual = mathUtils.calculateArea(7);
		assertEquals(expected, actual, "The calculate area method should calculate and format to .2f");
	}
	
	@Test
	@DisplayName("Testing divide method zero Arithmetic Exception.")
	@Tag("Math")
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(4, 0), "Divide by zero should throw");
	}	
		
	@Test
	@Disabled
	@DisplayName("TDD method should not run")
	void failedtest() {
		fail("This test should be disabled.");
	}
	
	
	@Nested
	@DisplayName("Running add method cases.")
	@Tag("Math")
	class AddTest {
		
		@Test
		void testAddingTwoPositives() {
			assertEquals(2, mathUtils.add(1, 1), "Add method should return the sum of two numbers");
		}
			
		@Test
		void testAddingTwoNegatives() {
			int expected = -2;
			int actual = mathUtils.add(-1, -1);
			assertEquals(expected, actual, () -> "should return the sum " + expected + " but returned " + actual);
		}
			
		@Test
		void testAddingAPositiveAndANegative() {
			assertEquals(0, mathUtils.add(-1, 1), "Add method should return the sum of two numbers");
		}
	}
	
	@Test
	@DisplayName("multiply method cases")
	@Tag("Math")
	void testMultiply() {
		//System.out.println("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
		
		assertAll(
				() -> assertEquals(0, mathUtils.multiply(1, 0)),
				() -> assertEquals(4, mathUtils.multiply(2, 2)),
				() -> assertEquals(6, mathUtils.multiply(2, 3))
				);
	}

}
