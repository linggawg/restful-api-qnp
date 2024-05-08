package com.lwg.restfulapi.service;

import com.lwg.restfulapi.persistence.ContactRepository;
import com.lwg.restfulapi.persistence.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
	@Autowired
	private ContactRepository repository;

	public Contact create(Contact contact) {
		return repository.save(contact);
	}

	public List<Contact> read() {
		return repository.findAll();
	}

	public Optional<Contact> readById(String id) {
		return repository.findById(id);
	}

	public Contact update(Contact contact, Contact request) {
		contact.setAddress(request.getAddress());
		contact.setName(request.getName());
		contact.setPhone(request.getPhone());
		contact.setEmail(request.getEmail());
		return repository.save(contact);
	}

	public void delete(Contact contact) {
		repository.delete(contact);
	}
}
