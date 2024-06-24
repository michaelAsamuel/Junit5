package com.empiricism.lnd.simple;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * 1. Create an instance of the class
 */
class SimpleMathTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAdd() {
		SimpleMath sm = new SimpleMath();
		int result =sm.add(2, 2);
		assertEquals(4, result);
		assertEquals(4, result, "the add method should return 4 for parameters 2 ,2 ");
		
		//assertArrayEquals
		//assertIterableEquals
		// https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html
	}
	
	@Test
	void testCalculateCircleArea() {
		SimpleMath sm = new SimpleMath();
		double  result = sm.calculateCircleArea(10);
		assertEquals(10.0*10.0*Math.PI, result);
		result = sm.calculateCircleArea(10.00);
		assertEquals(10.0*10.0*Math.PI, result);
	}
	
	@Test
	void testDiv() {
		SimpleMath sm = new SimpleMath();
		double  result = sm.div(12, 3);
		assertEquals(4.0, result);
		//double  result2 = sm.div(12, 0);
		//System.out.println(result2);
		assertThrows(ArithmeticException.class, () -> sm.div(11, 0));
	}

}
