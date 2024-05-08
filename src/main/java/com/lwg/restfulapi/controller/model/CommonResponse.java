package com.lwg.restfulapi.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommonResponse {
	private String status;
	private String duration;
	private Object data;
}
