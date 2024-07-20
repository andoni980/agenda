package com.springboot.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.agenda.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long>{

}
