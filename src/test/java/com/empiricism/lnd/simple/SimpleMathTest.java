package com.empiricism.lnd.simple;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
class SimpleMathTest {

	SimpleMath sm;
	
	@BeforeAll
	static void init() {
		System.out.println("Init just ran. Needs to be static as it runs before creation of instance");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		sm = new SimpleMath();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	//@EnabledOnOs(OS.MAC)
	void testAdd() {
		
		int result =sm.add(2, 2);
		assertEquals(4, result);
		assertEquals(4, result, "the add method should return 4 for parameters 2 ,2 ");
		assertAll(
				() -> assertEquals(0, sm.add(2, -2)),
				() -> assertEquals(0, sm.add(2, -2))					
				);
		//assertArrayEquals
		//assertIterableEquals
		// https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html
	}
	
	@Test
	void testCalculateCircleArea() {
		//SimpleMath sm = new SimpleMath();
		double  result = sm.calculateCircleArea(10);
		assertEquals(10.0*10.0*Math.PI, result);
		result = sm.calculateCircleArea(10.00);
		assertEquals(10.0*10.0*Math.PI, result);
	}
	
	@Test
	void testDiv() {
		//SimpleMath sm = new SimpleMath();
		double  result = sm.div(12, 3);
		assertEquals(4.0, result);
		//double  result2 = sm.div(12, 0);
		//System.out.println(result2);
		assertThrows(ArithmeticException.class, () -> sm.div(11, 0));
	}

}
