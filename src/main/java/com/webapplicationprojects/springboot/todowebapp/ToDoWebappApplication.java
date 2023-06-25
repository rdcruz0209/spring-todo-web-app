package com.webapplicationprojects.springboot.todowebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.SessionAttributes;

@SpringBootApplication
@SessionAttributes("username")
public class ToDoWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoWebappApplication.class, args);
     
    }

}
