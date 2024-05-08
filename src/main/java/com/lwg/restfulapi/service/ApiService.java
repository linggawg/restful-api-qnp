package com.lwg.restfulapi.service;

import com.lwg.restfulapi.persistence.ApiRepository;
import com.lwg.restfulapi.persistence.entity.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ApiService {
	@Autowired
	private ApiRepository apiRepository;

	public boolean checkLimit(String name) {
		if (apiRepository.findByName(name) == null) {
			Api api = new Api();
			api.setName(name);
			api.setCount(1);
			api.setStartTime(LocalDateTime.now().toString());
			api.setLastCallTime(api.getStartTime());
			apiRepository.save(api);
		} else {
			Api api = apiRepository.findByName(name);
			LocalDateTime startCall = LocalDateTime.parse(api.getStartTime());
			LocalDateTime lastCall = LocalDateTime.parse(api.getStartTime());

			if (LocalDateTime.now().isAfter(startCall.plusSeconds(60))) {
				api.setCount(1);
				api.setStartTime(LocalDateTime.now().toString());
				api.setLastCallTime(api.getStartTime());
				apiRepository.save(api);
				return true;
			} else if (LocalDateTime.now().isBefore(lastCall.plusSeconds(60)) && api.getCount() == 10) {
				return false;
			}
			api.setCount(api.getCount() + 1);
			api.setLastCallTime(LocalDateTime.now().toString());
			apiRepository.save(api);
		}
		return true;
	}
}
