package com.gestion.config;


import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories( basePackages = {"com.gestion.repository"})
public class MongoDbConfig {}

