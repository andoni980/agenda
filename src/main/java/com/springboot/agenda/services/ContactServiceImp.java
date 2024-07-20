package com.springboot.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.agenda.entities.Contact;
import com.springboot.agenda.repositories.ContactRepository;

@Service
public class ContactServiceImp implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Optional<Contact> getContactById(Long id) {
		return contactRepository.findById(id);
	}

	@Override
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public Contact updateContact(Contact contact) {
		if (contact.getId() == null) {
			return null;
		}

		return contactRepository.save(contact);
	}

	@Override
	public Boolean deleteContactById(Long id) {

		boolean eliminada = false;

		Optional<Contact> contactOpt = getContactById(id);

		if (contactOpt.isPresent()) {
			contactRepository.deleteById(id);
			eliminada = true;
		}

		return eliminada;

	}

}
