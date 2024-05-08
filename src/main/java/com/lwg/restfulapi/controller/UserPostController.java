package com.lwg.restfulapi.controller;

import com.lwg.restfulapi.controller.model.CommonResponse;
import com.lwg.restfulapi.controller.model.UserPostDto;
import com.lwg.restfulapi.service.ApiService;
import com.lwg.restfulapi.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping("/users-posts")
public class UserPostController {
	@Autowired
	private UserPostService service;

	@Autowired
	private ApiService apiService;

	@GetMapping()
	public ResponseEntity<CommonResponse> getUserAndPost() {
		CommonResponse response = new CommonResponse();
		try {
			if (!apiService.checkLimit("users-posts")) {
				response.setStatus("Failed");
				return new ResponseEntity<>(response, HttpStatus.TOO_MANY_REQUESTS);
			}

			Instant start = Instant.now();
			UserPostDto dto = service.consumeUserPostApi();
			Instant end = Instant.now();

			long timeElapsed = Duration.between(start, end).toMillis();
			double duration = (double) timeElapsed / 1000;

			response.setDuration(duration + " seconds");
			response.setData(dto);
			response.setStatus("Success");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setStatus("Failed");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}
