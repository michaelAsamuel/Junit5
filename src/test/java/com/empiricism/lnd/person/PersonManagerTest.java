package com.empiricism.lnd.person;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


class PersonManagerTest {
	PersonManager personManager;
	

	@BeforeEach
	void setUp() throws Exception {
		personManager = new PersonManager();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddContact() {
		
		personManager.addContact("Mark", "Fleming", "mark@gmail.com", "1234567899");
		assertFalse(personManager.getAllContacts().isEmpty());
		assertEquals(1, personManager.getAllContacts().size());
	}
	
	// Using Lamdas in test case
	@Test
	@DisplayName("First name is mandatory")
	void testValidateFirstName() {
		assertThrows(RuntimeException.class, () -> personManager.addContact("", "", "mark@gmail.com", "1234512345"));
		assertThrows(RuntimeException.class, () -> personManager.addContact(null, "", "mark@gmail.com", "1234512345"));
	}
	
	@Test
	@DisplayName("Run only in Dev")
	void testAddContactOnlyInDev() {
		assumeTrue("DEV".equals(System.getProperty("ENV")));
		personManager.addContact("Mark", "Fleming", "mark@gmail.com", "1234567899");
		assertFalse(personManager.getAllContacts().isEmpty());
		assertEquals(1, personManager.getAllContacts().size());
	}
	
	@ParameterizedTest
	@DisplayName("Add Contacts from Value Source")
	@ValueSource(strings = {"3331114447", "1234567899", "1231231234"})
	void testAddContactUsingValueSource(String phoneNo) {
		personManager.addContact("Mark", "Fleming", "mark@gmail.com", phoneNo);
		assertFalse(personManager.getAllContacts().isEmpty());
		assertEquals(1, personManager.getAllContacts().size());
	}
	
	@ParameterizedTest
	@DisplayName("Add Contacts from Method Source")
	@MethodSource("phoneNoList")
	void testAddContactUsingMethodSource(String phoneNo) {
		personManager.addContact("Mark", "Fleming", "mark@gmail.com", phoneNo);
		assertFalse(personManager.getAllContacts().isEmpty());
		assertEquals(1, personManager.getAllContacts().size());
	}
	
	@ParameterizedTest
	@DisplayName("Add Contacts from Csv Source")
	@CsvSource({"3331114447", "1234567899", "1231231234"})
	void testAddContactUsingCsvSource(String phoneNo) {
		personManager.addContact("Mark", "Fleming", "mark@gmail.com", phoneNo);
		assertFalse(personManager.getAllContacts().isEmpty());
		assertEquals(1, personManager.getAllContacts().size());
	}
	
	@ParameterizedTest
	@DisplayName("Add Contacts from CSV File Source")
	@CsvFileSource(resources = "/data.csv")
	void testAddContactUsingCsvFileSource(String phoneNo) {
		personManager.addContact("Mark", "Fleming", "mark@gmail.com", phoneNo);
		assertFalse(personManager.getAllContacts().isEmpty());
		assertEquals(1, personManager.getAllContacts().size());
	}
	
	
	
	private static List<String> phoneNoList(){
		return Arrays.asList("3331114447", "1234567899", "1231231234");
	}
	
	
	

}
