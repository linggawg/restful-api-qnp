package com.lwg.restfulapi.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserPostDto {
	private Post[] posts;
	private User[] users;
}
