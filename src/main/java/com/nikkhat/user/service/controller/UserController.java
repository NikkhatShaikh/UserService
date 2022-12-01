package com.nikkhat.user.service.controller;

import com.nikkhat.user.service.entity.User;
import com.nikkhat.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(@RequestBody User user){

        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }


    @GetMapping("/getsingleuser/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable  String userId){

        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);

    }


    @GetMapping("/getalluser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();

        return  ResponseEntity.ok(allUser);
    }


}
