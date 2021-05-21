package com.addressbook.application.service;

import java.util.List;

import com.addressbook.application.dto.ContactDTO;
import com.addressbook.application.model.ContactData;

public interface IAddressBookService {

	List<ContactData> getAddressBookData();
	
	ContactData getContactById(int contactId);
	
	ContactData createContact(ContactDTO contactDTO);

	void deleteContact(int contactid);

	ContactData updateContactData(int contactId, ContactDTO contactDTO);
}
