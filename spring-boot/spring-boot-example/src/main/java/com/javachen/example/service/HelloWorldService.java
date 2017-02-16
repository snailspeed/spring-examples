package com.javachen.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev", "qa"})
public class HelloWorldService implements MessageService {

    @Value("${name:World}")
    private String name;

    public String getMessage() {
        return "Hello " + this.name;
    }

}