package com.addressbook.application.service;

import java.util.ArrayList;
import java.util.List;

import com.addressbook.application.dto.ContactDTO;
import com.addressbook.application.model.ContactData;

public class AddressBookService implements IAddressBookService {

	@Override
	public List<ContactData> getAddressBookData() {
		List<ContactData> contactDataList = new ArrayList<>();
		contactDataList.add(new ContactData(1, new ContactDTO("Galfauger","Basile", 40000)));
		
		return contactDataList;
	}

	@Override
	public ContactData getEmployeePayRollDataById(int contactId) {
		ContactData contactData = null;
		contactData = new ContactData(1, new ContactDTO("Galfauger","Basile", 40000));
		
		return contactData;
	}

	@Override
	public ContactData createEmployeePayRollData(ContactDTO contactDTO) {
		ContactData contactData = null;
		contactData = new ContactData(1, contactDTO);
		
		return contactData;
	}

	@Override
	public ContactData updateEmployeePayRollData(ContactDTO contactDTO) {
		ContactData contactData = null;
		contactData = new ContactData(1, contactDTO);
		
		return contactData;
	}

	@Override
	public void deleteEmployeePayRollData(int contactid) {}

}
