package com.lwg.restfulapi.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "api")
public class Api {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "count")
	private int count;

	@Column(name = "start_time")
	private String startTime;

	@Column(name = "last_call_time")
	private String lastCallTime;
}
