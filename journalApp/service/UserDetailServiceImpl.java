package com.tutjava.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tutjava.journalApp.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;  // Assuming you have a UserRepository to fetch users from a database

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user from the repository
        com.tutjava.journalApp.model.User user = userRepository.findByUsername(username);

        // Check if user is found, if not throw exception
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Return UserDetails using the User.builder()
        return User.builder()
                .username(user.getUsername())
                .password("{noop}" + user.getPassword())   // Password should be already encoded
                .roles(user.getRoles().toArray(new String[0]))  // Convert roles to an array of strings
                .build();
    }
}
