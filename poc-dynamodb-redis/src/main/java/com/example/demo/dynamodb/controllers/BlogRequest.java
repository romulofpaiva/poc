package com.example.demo.dynamodb.controllers;

import java.util.UUID;

import com.example.demo.dynamodb.models.Blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogRequest {
	
	@NonNull
	private String text;

	public Blog toModel() {
		return new Blog(UUID.randomUUID().toString(), this.text);
	}

}
