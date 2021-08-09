package com.example.demo.dynamodb.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dynamodb.repositories.BlogRepository;

@RestController
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	private BlogRepository blogRepository;
	
	@PostMapping
	public ResponseEntity<?> newPost(@Valid @RequestBody BlogRequest request) {
		return ResponseEntity.ok(blogRepository.save(request.toModel()));
	}
	
	@GetMapping("/{key}")
	public ResponseEntity<?> getPost(@PathVariable String key) {
		return ResponseEntity.ok(blogRepository.findById(key));
	}
	
	@GetMapping
	public ResponseEntity<?> listPosts() {
		return ResponseEntity.ok(blogRepository.findAll());
	}

}
