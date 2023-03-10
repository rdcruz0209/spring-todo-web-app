package com.webapplicationprojects.springboot.todowebapp.login;

public interface AuthenticationService {

    boolean authenticate(String name, String password);
}
