package com.empiricism.lnd.person;

import java.util.regex.Pattern;

public class Person {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	
	
	
	public Person(String firstName, String lastName, String email, String phoneNo) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNo=" + phoneNo
				+ "]";
	}
	
	public void validateFirstName() {
		if(this.firstName.isBlank()) {
			throw new RuntimeException("firstName cannot be null");
		}
	}
	
	
	public boolean validateEmail(String email) {
		String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@" 
		        + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";
	    //if(!patternMatches(email, regexPattern))
	    	return patternMatches(email, regexPattern);
	}
	
	public static boolean patternMatches(String emailAddress, String regexPattern) {
		
	    return Pattern.compile(regexPattern)
	      .matcher(emailAddress)
	      .matches();
	}
	
	public void validatePhoneNumber() {
		if(this.phoneNo.isBlank()) {
			throw new RuntimeException("Phone number is mandatory");
		}
		if(this.phoneNo.length() != 10) {
			throw new RuntimeException("Phone number should be 10 digits");
		}
		if(!this.phoneNo.matches("\\d+")){
			System.out.println(this.phoneNo);
			throw new RuntimeException("Phone number should be only digits");
		}
	}
	

}
