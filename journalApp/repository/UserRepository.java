package com.tutjava.journalApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tutjava.journalApp.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username); // Query method to find a user by username
}
