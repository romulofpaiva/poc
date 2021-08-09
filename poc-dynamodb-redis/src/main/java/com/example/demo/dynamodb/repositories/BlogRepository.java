package com.example.demo.dynamodb.repositories;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.example.demo.dynamodb.models.Blog;

@EnableScan
@Repository
public interface BlogRepository extends DynamoDBCrudRepository<Blog, String> {

}
