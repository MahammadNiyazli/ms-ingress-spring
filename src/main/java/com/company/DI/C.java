package com.company.DI;

import org.springframework.stereotype.Repository;

@Repository
public class C {
    private final D d;

    public C(D d) {
        System.err.println("c initialized");
        this.d = d;
    }
}
