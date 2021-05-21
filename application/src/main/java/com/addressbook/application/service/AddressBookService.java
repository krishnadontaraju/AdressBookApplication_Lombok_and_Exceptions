package com.addressbook.application.service;

import java.util.ArrayList;
import java.util.List;

import com.addressbook.application.dto.ContactDTO;
import com.addressbook.application.exception.AddressBookServiceException;
import com.addressbook.application.model.ContactData;
import com.employee.employeeapplication.exception.EmployeeServiceException;

public class AddressBookService implements IAddressBookService {
	
	private List<ContactData> contactDataList = new ArrayList<>();

	@Override
	public List<ContactData> getAddressBookData() {
		
		return contactDataList;
	}

	@Override
	public ContactData getContactById(int contactId) {
		
		return contactDataList.stream()
				.filter(contact -> contact.getContactId() == contactId)
				.findFirst()
				.orElseThrow(() -> new AddressBookServiceException("Employe with your ID not found"));
	}

	@Override
	public ContactData createContact(ContactDTO contactDTO) {
		ContactData contactData = null;
		contactData = new ContactData(contactDataList.size() + 1 , contactDTO);
		contactDataList.add(contactData);
		return contactData;
	}

	@Override
	public ContactData updateContactData(int contactId , ContactDTO contactDTO) {
		ContactData contactData = this.getContactById(contactId);
		contactData.setFirstName(contactDTO.firstName);
		contactData.setLastName(contactDTO.lastName);
		contactData.setContactNumber(contactDTO.contactNumber);
		
		contactDataList.set(contactId - 1, contactData);
		
		return contactData;
	}

	@Override
	public void deleteContact(int contactid) {
		contactDataList.remove(contactid -1);
	}

}
