package com.oocl.web.sampleWebApp.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello World";
    }
    
    @RequestMapping("/hello")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String show() {
        return "Hello World";
    }
    
    @RequestMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody HashMap<String, String> getUser() {
    	HashMap<String, String> map = new HashMap<>();
    	map.put("user", "Amy");
        return map;
    }
    
    @PostMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody HashMap<String, String> createUser(@PathVariable String userId,@RequestBody HashMap<String, String> user) {
    	user.put("userId", userId);
    	return user;
    }
}