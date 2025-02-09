package com.tutjava.journalApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutjava.journalApp.model.User;
import com.tutjava.journalApp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private BCryptPasswordEncoder passwordEncoder;

    public User createUser(String username, String password, List<String> roles) {
        // String encodedPassword = passwordEncoder.encode(password);
        User user = new User(username, password,roles);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
