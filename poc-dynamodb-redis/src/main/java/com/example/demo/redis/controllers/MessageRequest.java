package com.example.demo.redis.controllers;

import java.util.UUID;

import com.example.demo.redis.models.Message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {

	@NonNull
	private String text;

	public Message toModel() {
		return new Message(UUID.randomUUID().toString(), this.text);
	}
	
}
