package com.example.demo.db;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Integer> {
    public User findByUsername(String username);
}