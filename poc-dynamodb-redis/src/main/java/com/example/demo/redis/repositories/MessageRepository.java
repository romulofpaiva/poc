package com.example.demo.redis.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.redis.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, String> {

}
