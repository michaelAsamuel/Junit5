package com.empiricism.lnd.simple;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;



/**
 * 1. Create an instance of the class
 */

/*
 * 
Default is PER_Method
Tests need to be independent of each other so setup and teardown recommended at method level
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 */
class SimpleMathTestNested {

	SimpleMath sm;
	

	@BeforeEach
	void setUp() throws Exception {
		sm = new SimpleMath();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Nested
	class NestedExample {
		
		@Test
		void testAdd() {
			
			int result =sm.add(2, 2);
			assertEquals(4, result);
			//assertEquals(4, result, "the add method should return 4 for parameters 2 ,2 ");
			assertEquals(4, result, () -> "the add method should return  4 for parameters 2 ,2 ");
			assertAll(
					() -> assertEquals(0, sm.add(2, -2)),
					() -> assertEquals(0, sm.add(2, -2))					
					);
		}
		
		@Test
		void testCalculateCircleArea() {
			
			double  result = sm.calculateCircleArea(10);
			assertEquals(10.0*10.0*Math.PI, result);
			result = sm.calculateCircleArea(10.00);
			assertEquals(10.0*10.0*Math.PI, result);
		}
		
	}


	

	
	@Test
	@RepeatedTest(value = 3, 
			name="Repeating div test  {currentRepetition} of  {totalRepetition}" )
	void testDiv() {

		
		double  result = sm.div(12, 3);
		assertEquals(4.0, result);
	}

}
