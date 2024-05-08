package com.lwg.restfulapi.persistence;

import com.lwg.restfulapi.persistence.entity.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<Api, String> {
	Api findByName(String name);
}
