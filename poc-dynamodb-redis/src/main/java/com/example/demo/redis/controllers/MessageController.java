package com.example.demo.redis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.redis.repositories.MessageRepository;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@PostMapping
	public ResponseEntity<?> newMessage(@Validated @RequestBody MessageRequest request) {
		return ResponseEntity.ok(messageRepository.save(request.toModel()));
	}
	
	@GetMapping("/{key}")
	public ResponseEntity<?> getMessage(@PathVariable String key) {
		return ResponseEntity.ok(messageRepository.findById(key));
	}
	
	@GetMapping
	public ResponseEntity<?> listMessages() {
		return ResponseEntity.ok(messageRepository.findAll());
	}

}
