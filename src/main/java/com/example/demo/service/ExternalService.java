package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ExternalService {

    public String getDescription() {
        return "My description";
    }
}
