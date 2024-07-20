package com.springboot.agenda.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.agenda.entities.Contact;
import com.springboot.agenda.services.ContactService;

@CrossOrigin
@RestController
@RequestMapping("api/contacts")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping
	public ResponseEntity<List<Contact>> getAllContacts() {
		return new ResponseEntity<>(contactService.getAllContacts(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
		return contactService.getContactById(id).map(contact -> new ResponseEntity<>(contact, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/save")
	public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
		contact.setCreatedDate(LocalDateTime.now());
		return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
		return new ResponseEntity<>(contactService.updateContact(contact), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Boolean> deleteNota(@PathVariable Long id) {
		if(contactService.deleteContactById(id)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
	}
}
