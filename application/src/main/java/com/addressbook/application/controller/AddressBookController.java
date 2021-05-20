package com.addressbook.application.controller;

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

@RestController
@RequestMapping("/book")
public class AddressBookController {

	@RequestMapping(value = {"","/","/contacts"})
    public ResponseEntity<String> getAddressBookInformation(){
		ContactData contactData = null;
		contactData = new ContactData(1, new ContactDTO("Galefaugger","Basiela", 789456123));
    	ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , contactData);
        return new ResponseEntity<>("Get call is succesful ",HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<String> getAddressBookInformation(@PathVariable("empId") int contactId){
    	ContactData contactData = null;
    	contactData = new ContactData(1, new ContactDTO("Galefaugger","Basiela", 789456123));
    	ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , contactData);
    	return new ResponseEntity<>("Get call is succesful for id "+contactId,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addContact(@RequestBody ContactDTO contactDTO){
    	ContactData contactData = null;
    	contactData = new ContactData(1, contactDTO);
    	ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , contactData);
        return new ResponseEntity<>("Added the contact Data : "+contactDTO , HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateContact(@RequestBody ContactDTO contactDTO){
    	ContactData contactData = null;
    	contactData = new ContactData(1, contactDTO);
    	ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , contactData);
        return new ResponseEntity<>("Update the contact's Pay Roll data : "+contactDTO , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable("empId") int contactId){
    	ResponseDTO responseDTO = new ResponseDTO("Deleted successfully ","Deleted id"+contactId);
        return new ResponseEntity<>("Deleted contact's Data for id : "+contactId , HttpStatus.OK);
    }
}
