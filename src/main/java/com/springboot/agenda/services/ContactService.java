package com.springboot.agenda.services;

import java.util.List;
import java.util.Optional;

import com.springboot.agenda.entities.Contact;

public interface ContactService {
 
	public List<Contact> getAllContacts();
	public Optional<Contact> getContactById(Long id);
	public Contact saveContact(Contact contact);
	public Contact updateContact(Contact contact);
	public Boolean deleteContactById(Long id);
	
}
