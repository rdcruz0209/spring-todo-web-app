package com.webapplicationprojects.springboot.todowebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    //authenticate a user
    public boolean authenticate(String name, String password) {

        boolean isValidUser = name.equals("Robert") && password.equals("1");

        return isValidUser;
    }
}
