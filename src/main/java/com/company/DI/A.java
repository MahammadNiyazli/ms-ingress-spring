package com.company.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A {
    private final B b;
    private C c;

    public A(B b) {
        System.err.println("a initialized");
        this.b = b;
    }

    @Autowired
    public void setC(C c){
        System.err.println("setter called");
        this.c = c;
    }
}
