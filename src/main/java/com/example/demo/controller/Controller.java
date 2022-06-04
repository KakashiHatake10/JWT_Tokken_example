package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        try {
            this.userService.save(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll() {
        try {
            List<User> allUser = this.userService.getAllUser();
            return ResponseEntity.ok(allUser);
        } catch (Exception e) {

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

