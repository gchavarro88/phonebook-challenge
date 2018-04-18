package com.phonebook.bo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the "Contact" database table.
 * 
 */
@Entity
@Table(name="\"Contact\"")
@NamedQueries({
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c"),
@NamedQuery(name="Contact.findbyParameter", query="SELECT c FROM Contact c WHERE UPPER(c.firstName) LIKE CONCAT('%',UPPER(:parameter),'%') "
		+ "OR UPPER(c.lastName) LIKE CONCAT('%',UPPER(:parameter),'%') OR CAST(c.phone AS TEXT) LIKE CONCAT('%', CAST(:parameter AS TEXT),'%')")
})
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"FIRSTNAME\"")
	private String firstName;

	@Column(name="\"LASTNAME\"")
	private String lastName;

	@Id
	@Column(name="\"PHONE\"")
	private Long phone;

	public Contact() {
	}
	
	

	public Contact(String firstName, String lastName, Long phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}


	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

}