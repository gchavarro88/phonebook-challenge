package com.phonebook.bs;

import java.util.List;

import com.phonebook.bo.Contact;

public interface IManageContact {

	public void addContact(Contact contact) throws Exception;
	
	public List<Contact> readContacts() throws Exception;
	
	public List<Contact> searchContact(String keyWord) throws Exception;
}
