package com.empiricism.lnd.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

	@BeforeEach
	void setUp() throws Exception {
		Person p = new Person("Gabriel", "Samuel", "gabe@gmail.com", "123456789");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testValidateFirstName() {
		Person p = new Person("Gabriel", "Samuel", "gabe@gmail.com", "123456789");
		System.out.println(p.getFirstName());
		assertTrue(p.getFirstName().length()>0);
		
	}

	@Test
	void testValidateEmail() {
		Person p = new Person("Gabriel", "Samuel", "gabegmail.com", "123456789");
		assertTrue(p.validateEmail("gabe@gmail.com"));
	}

}
