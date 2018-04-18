package com.phonebook.bs;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.phonebook.bo.Contact;
import com.phonebook.dao.ContactDAO;

/**
 * This implementation allows to create a layer to do logic 
 * before to access to the data
 * @author gustavochavarro
 **/
@Component("manageContact")
@Transactional
public class ManageContactImpl implements IManageContact {

	ContactDAO contactDAO;
	
	@Override
	public void addContact(Contact contact) throws Exception {
		contactDAO.addContact(contact);
	}

	@Override
	public List<Contact> readContacts() throws Exception {
		List<Contact> result = contactDAO.readContact();
		return result;
	}

	@Override
	public List<Contact> searchContact(String keyWord) throws Exception {
		List<Contact> result = contactDAO.searchContact(keyWord);
		return result;
	}

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}
}
