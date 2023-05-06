package com.company.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    A a;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFiles(){
        return ResponseEntity.ok("success");
    }

}
