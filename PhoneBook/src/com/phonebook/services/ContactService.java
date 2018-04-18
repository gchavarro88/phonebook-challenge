package com.phonebook.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.bo.Contact;
import com.phonebook.bs.IManageContact;

@RestController
@RequestMapping("/contact")
public class ContactService {

	private static final String enconding = "UTF-8";
	private IManageContact manageContact;
	
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity addContact(@RequestBody Contact contact) {
		try {
			manageContact.addContact(contact);
			return new ResponseEntity(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@RequestMapping(value = "/searchContact", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<Contact>> searchContact(@RequestBody String keyWord) {
		try {
			List<Contact> result = manageContact.searchContact(keyWord);
			return new ResponseEntity<List<Contact>>(result, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/readContacts", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<Contact>> readContacts() {
		
		try {
			List<Contact> result = manageContact.readContacts();
			return new ResponseEntity<List<Contact>>(result, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public void setManageContact(IManageContact manageContact) {
		this.manageContact = manageContact;
	}
	
}
