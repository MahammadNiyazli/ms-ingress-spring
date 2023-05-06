package com.company.DI;

import org.springframework.stereotype.Service;

@Service
public class B {
    private final C c;

    public B(C c) {
        System.err.println("b initialized");
        this.c = c;
    }
}
