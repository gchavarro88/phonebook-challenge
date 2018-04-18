package com.phonebook.dao;

import java.util.List;

import com.phonebook.bo.Contact;

public interface ContactDAO {

	public void addContact(Contact contact) throws Exception;
	
	public List<Contact> readContact() throws Exception;
	
	public List<Contact> searchContact(String keyWord) throws Exception;
}
 