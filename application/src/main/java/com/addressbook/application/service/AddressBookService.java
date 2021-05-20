package com.addressbook.application.service;

import java.util.ArrayList;
import java.util.List;

import com.addressbook.application.dto.ContactDTO;
import com.addressbook.application.model.ContactData;

public class AddressBookService implements IAddressBookService {
	
	private List<ContactData> contactDataList = new ArrayList<>();

	@Override
	public List<ContactData> getAddressBookData() {
		
		return contactDataList;
	}

	@Override
	public ContactData getEmployeePayRollDataById(int contactId) {
		
		return contactDataList.get(contactId - 1);
	}

	@Override
	public ContactData createEmployeePayRollData(ContactDTO contactDTO) {
		ContactData contactData = null;
		contactData = new ContactData(contactDataList.size() + 1 , contactDTO);
		contactDataList.add(contactData);
		return contactData;
	}

	@Override
	public ContactData updateEmployeePayRollData(int contactId , ContactDTO contactDTO) {
		ContactData contactData = this.getEmployeePayRollDataById(contactId);
		contactData.setFirstName(contactDTO.firstName);
		contactData.setLastName(contactDTO.lastName);
		contactData.setContactNumber(contactDTO.contactNumber);
		
		contactDataList.set(contactId - 1, contactData);
		
		return contactData;
	}

	@Override
	public void deleteEmployeePayRollData(int contactid) {
		contactDataList.remove(contactid -1);
	}

}
