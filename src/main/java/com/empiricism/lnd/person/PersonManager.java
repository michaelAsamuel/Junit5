 package com.empiricism.lnd.person;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PersonManager {
	
	Map<String, Person> contactList = new ConcurrentHashMap<String, Person>();
	
	
	public void addContact(String firstName, String lastName, String email, String phoneNo) {
		Person person = new Person(firstName, lastName, email, phoneNo);
		validatePerson(person);
		contactList.put(person.getEmail(), person);
	}
	
    private void validatePerson(Person person) {
        person.validateFirstName();
        person.validateEmail(person.getEmail());
        person.validatePhoneNumber();
    }
    
    public Collection<Person> getAllContacts() {
        return contactList.values();
    }
	

	

	

}
