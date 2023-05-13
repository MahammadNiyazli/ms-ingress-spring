package com.company.DI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/users")
public class UserController {


    @GetMapping
    public ResponseEntity<String> getAllUsers(@RequestParam("createdAtStart") LocalDate createdAtStart,
                                              @RequestParam("createdAtEnd") LocalDate createdAtEnd){
        return ResponseEntity.ok("user list");
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody String user){
        return ResponseEntity.ok("save user");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody String user, @PathVariable("id") Long id){
        return ResponseEntity.ok("update user");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        return ResponseEntity.ok("delete user");
    }

}
