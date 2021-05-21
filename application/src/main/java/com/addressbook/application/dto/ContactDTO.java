package com.addressbook.application.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ContactDTO {

	@NotEmpty(message = " First name cannot be empty")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$" ,message = "The First name was not according to the pattern ")
	public String firstName;
	
	@NotEmpty(message = " Last name cannot be empty")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$" ,message = "The Last name was not according to the pattern ")
	public String lastName;
	
	@NotEmpty(message = " Last name cannot be empty")
	@Pattern(regexp = "^[0-9]{10}$" ,message = "The Contact number must have 10 digits and,was not according to the pattern ")
	public long contactNumber;
	
	
	public ContactDTO(String firstName,String lastNameString , long contactNumber) {
		this.firstName = firstName;
		this.lastName = lastNameString;
		this.contactNumber = contactNumber;
	}


	@Override
	public String toString() {
		return "firstName = " + firstName +", lastName = "+lastName+ ", contactNumber = " + contactNumber;
	}
	
}
