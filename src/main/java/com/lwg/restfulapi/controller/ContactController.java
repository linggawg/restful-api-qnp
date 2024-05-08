package com.lwg.restfulapi.controller;

import com.lwg.restfulapi.controller.model.CommonResponse;
import com.lwg.restfulapi.persistence.entity.Contact;
import com.lwg.restfulapi.service.ApiService;
import com.lwg.restfulapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	private ContactService service;

	@Autowired
	private ApiService apiService;

	@PostMapping()
	public ResponseEntity<CommonResponse> saveContact(@RequestBody Contact contact) {
		CommonResponse response = new CommonResponse();
		try {
			if (!apiService.checkLimit("POST-contact")) {
				response.setStatus("Failed");
				return new ResponseEntity<>(response, HttpStatus.TOO_MANY_REQUESTS);
			}

			response.setData(service.create(contact));
			response.setStatus("Success");

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setStatus("Failed");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping()
	public ResponseEntity<CommonResponse> getContacts() {
		CommonResponse response = new CommonResponse();
		try {
			if (!apiService.checkLimit("GET-contact")) {
				response.setStatus("Failed");
				return new ResponseEntity<>(response, HttpStatus.TOO_MANY_REQUESTS);
			}

			response.setData(service.read());
			response.setStatus("Success");

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setStatus("Failed");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<CommonResponse> getContactById(@PathVariable String id) {
		CommonResponse response = new CommonResponse();
		try {
			if (!apiService.checkLimit("GET-contact-id")) {
				response.setStatus("Failed");
				return new ResponseEntity<>(response, HttpStatus.TOO_MANY_REQUESTS);
			}

			Optional<Contact> contactOptional = service.readById(id);
			if (contactOptional.isEmpty()) {
				response.setStatus("Failed");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}

			response.setData(contactOptional.get());
			response.setStatus("Success");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setStatus("Failed");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping()
	public ResponseEntity<CommonResponse> updateContact(@RequestBody Contact request) {
		CommonResponse response = new CommonResponse();
		try {
			if (!apiService.checkLimit("PUT-contact")) {
				response.setStatus("Failed");
				return new ResponseEntity<>(response, HttpStatus.TOO_MANY_REQUESTS);
			}

			Optional<Contact> contact = service.readById(request.getId());
			if (contact.isEmpty()) {
				response.setStatus("Failed");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}

			response.setData(service.update(contact.get(), request));
			response.setStatus("Success");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setStatus("Failed");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CommonResponse> deleteContact(@PathVariable String id) {
		CommonResponse response = new CommonResponse();
		try {
			if (!apiService.checkLimit("DELETE-contact")) {
				response.setStatus("Failed");
				return new ResponseEntity<>(response, HttpStatus.TOO_MANY_REQUESTS);
			}

			Optional<Contact> contact = service.readById(id);
			if (contact.isEmpty()) {
				response.setStatus("Failed");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}

			response.setData(contact.get());
			response.setStatus("Success");
			service.delete(contact.get());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setStatus("Failed");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}
