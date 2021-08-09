package com.example.demo.redis.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Data;
import lombok.NonNull;

@Data
@RedisHash
public class Message {

	@Id
	@Indexed
	@NonNull
	private String key;

	@NonNull
	private String text;
}
