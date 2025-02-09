package com.tutjava.journalApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutjava.journalApp.model.User;
import com.tutjava.journalApp.service.UserService;


@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user.getUsername(), user.getPassword(), user.getRoles());
    }

    @GetMapping
    public List<User> getAllUsers() {
        //stem.out.println("-----here------");

        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        System.out.println(username);
        return userService.getUserByUsername(username);
    }
    //    @PostMapping
    // public ResponseEntity<User> createUser(@RequestBody User user) {
    //     // Create a new user using the service layer
    //     User createdUser = userService.createUser(user.getUsername(), user.getPassword(), user.getRoles());
    //     return ResponseEntity.ok(createdUser);
    // }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting( ) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        
        return new ResponseEntity<>("hi"+authentication.getName()+"",HttpStatus.OK);
    }
    
    
}
