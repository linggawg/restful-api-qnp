package com.lwg.restfulapi.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private String birthDate;
	private Login login;
	private Address address;
	private String phone;
	private String website;
	private Company company;
}
