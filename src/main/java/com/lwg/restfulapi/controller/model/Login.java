package com.lwg.restfulapi.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Login {
	private String uuid;
	private String username;
	private String password;
	private String md5;
	private String sha1;
	private String registered;
}
