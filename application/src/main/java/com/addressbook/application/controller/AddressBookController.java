package com.addressbook.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addressbook.application.dto.ContactDTO;
import com.addressbook.application.dto.ResponseDTO;
import com.addressbook.application.model.ContactData;
import com.addressbook.application.service.AddressBookService;
import com.addressbook.application.service.IAddressBookService;

@RestController
@RequestMapping("/book")
public class AddressBookController {
	
	@Autowired 
	private IAddressBookService addressBookService;

	@RequestMapping(value = {"","/","/contacts"})
    public ResponseEntity<ResponseDTO> getAddressBookInformation(){
		List<ContactData> contactDataList = null;
		contactDataList = addressBookService.getAddressBookData();
    	ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , contactDataList);
    	return new ResponseEntity<ResponseDTO>(responseDTO ,HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getAddressBookInformation(@PathVariable("empId") int contactId){
    	ContactData contactData = null;
    	contactData = addressBookService.getEmployeePayRollDataById(contactId);
    	ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , contactData);
    	return new ResponseEntity<ResponseDTO>(responseDTO ,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addContact(@RequestBody ContactDTO contactDTO){
    	ContactData contactData = null;
    	contactData = addressBookService.createEmployeePayRollData(contactDTO);
    	ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , contactData);
        return new ResponseEntity<>("Added the contact Data : "+responseDTO , HttpStatus.OK);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<String> updateContact(@PathVariable("contactId") int contactId ,@RequestBody ContactDTO contactDTO){
    	ContactData contactData = null;
    	contactData = addressBookService.updateEmployeePayRollData(contactId,contactDTO);
    	ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , contactData);
        return new ResponseEntity<>("Update the contact's Pay Roll data : "+responseDTO , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable("empId") int contactId){
    	addressBookService.deleteEmployeePayRollData(contactId);
    	ResponseDTO responseDTO = new ResponseDTO("Deleted successfully ","Deleted id"+contactId);
        return new ResponseEntity<>("Deleted contact's Data for id : "+responseDTO , HttpStatus.OK);
    }
}
