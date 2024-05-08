package com.lwg.restfulapi.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Post {
	private String id;
	private String slug;
	private String url;
	private String title;
	private String content;
	private String image;
	private String thumbnail;
	private String status;
	private String category;
	private String publishedAt;
	private String updatedAt;
	private String userId;
}
