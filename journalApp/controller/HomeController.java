package com.tutjava.journalApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tutjava.journalApp.model.User;
import com.tutjava.journalApp.service.UserService;


@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home() {
        return "Welcome to home";
    }
     @GetMapping("/home/users")
    public List<User> getAllUsers() {
        //stem.out.println("-----here------");

        return userService.getAllUsers();
    }
    @GetMapping("home/welcome")
    public String welcome() {

        RestTemplate restTemplate = new RestTemplate();
String fooResourceUrl
  = "http://localhost:8080/home";
ResponseEntity<String> response
  = restTemplate.getForEntity(fooResourceUrl , String.class);
// Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
System.out.println(response.getStatusCode());
System.out.println(response.getBody());


        return "Hello Vipul";
    }
    @GetMapping("home/welcome/1")
    public String welcome1(){

            try{
      RestTemplate restTemplate = new RestTemplate();
         String url = "https://open-weather13.p.rapidapi.com/city/landon/EN";

        // Set up the headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "acd6b8c0c3mshb568300a12576c9p1e3379jsn17995154e51f");
        headers.set("x-rapidapi-host", "open-weather13.p.rapidapi.com");

        // Create the HttpEntity with the headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Make the GET request and capture the response
        ResponseEntity<String> response = restTemplate.exchange(
            url,
            org.springframework.http.HttpMethod.GET,
            entity,
            String.class
        );

        // Print the response
        System.out.println(response.getBody());
            }
            catch(Exception e){
                System.out.println(e);
            }
        return "HI welcome to this place";
    }
    
}
