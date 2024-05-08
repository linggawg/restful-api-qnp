package com.lwg.restfulapi.service;

import com.lwg.restfulapi.controller.model.Post;
import com.lwg.restfulapi.controller.model.User;
import com.lwg.restfulapi.controller.model.UserPostDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class UserPostService {

	public UserPostDto consumeUserPostApi() {
		RestClient restClient = RestClient.create();

		var usersResponse = restClient
				.get()
				.uri("https://jsonplaceholder.org/users")
				.retrieve()
				.toEntity(User[].class);

		var postResponse = restClient
				.get()
				.uri("https://jsonplaceholder.org/posts")
				.retrieve()
				.toEntity(Post[].class);

		UserPostDto UserPostDto = new UserPostDto();
		UserPostDto.setUsers(usersResponse.getBody());
		UserPostDto.setPosts(postResponse.getBody());
		return UserPostDto;
	}
}
