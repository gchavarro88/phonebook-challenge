package com.phonebook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.phonebook.bo.Contact;

@Component("contactDAO")
public class ContactDAOImpl implements ContactDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public void addContact(Contact contact) throws Exception {
		if(null != contact) {
			try {
				entityManager.persist(contact);
			} catch(Exception e) {
				entityManager.getTransaction().rollback();
				throw e;
			}
			
		}	
	}

	@Transactional
	@Override
	public List<Contact> readContact() throws Exception {
		List<Contact> result = null;
		try {
			Query query = entityManager.createNamedQuery("Contact.findAll");
			result = (List<Contact>) query.getResultList();
			
		} catch(Exception e) {
			throw e;
		}
		return result;
	}

	@Transactional
	@Override
	public List<Contact> searchContact(String keyWord) throws Exception {
		List<Contact> result = null;
		try {
			Query query = entityManager.createNamedQuery("Contact.findbyParameter");
			query.setParameter("parameter", keyWord);
			result = (List<Contact>) query.getResultList();
			
		} catch(Exception e) {
			throw e;
		}
		return result;
	}

}
