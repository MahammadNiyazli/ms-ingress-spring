package com.company.DI.controller;

import com.company.DI.request.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final User user;

    public UserController(User user) {
        this.user = user;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> user(@PathVariable("id") Long id){
        System.err.println(user);
        return ResponseEntity.ok(user.toString());
    }

}
