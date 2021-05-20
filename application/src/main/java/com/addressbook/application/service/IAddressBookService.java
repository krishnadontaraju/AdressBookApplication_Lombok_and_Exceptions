package com.addressbook.application.service;

import java.util.List;

import com.addressbook.application.dto.ContactDTO;
import com.addressbook.application.model.ContactData;

public interface IAddressBookService {

	List<ContactData> getAddressBookData();
	
	ContactData getEmployeePayRollDataById(int contactId);
	
	ContactData createEmployeePayRollData(ContactDTO contactDTO);
	
	ContactData updateEmployeePayRollData(ContactDTO contactDTO);
	
	void deleteEmployeePayRollData(int contactid);
}
