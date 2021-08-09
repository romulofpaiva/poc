package com.example.demo.dynamodb.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.example.demo.dynamodb.repositories.BlogRepository;

@Configuration
@EnableDynamoDBRepositories(basePackageClasses = BlogRepository.class)
public class DynamoDBConfig {

	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		ClientConfiguration clientConfiguration = new ClientConfiguration();
		clientConfiguration.setProxyHost("localhost");
		clientConfiguration.setProxyPort(8000);
		
		return AmazonDynamoDBClientBuilder.standard()
				.withClientConfiguration(clientConfiguration)
				.withRegion(Regions.US_EAST_1)
				.build();
	}
}
