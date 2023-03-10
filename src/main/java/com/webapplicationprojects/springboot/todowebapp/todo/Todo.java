package com.webapplicationprojects.springboot.todowebapp.todo;

import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

//Database (MySQL)
//create a List of Todos ==> we will use real database (H2, MySQL)


@Controller
public class Todo {


    private int id;
    @Size(min = 6, message = "Enter at least 6 characters")
    private String username;
    @Size(min = 10, message = "Enter at least 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean status;

    public Todo(int id, String username, String description, LocalDate targetDate, boolean status) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.status = status;
    }

    //study how the instance values of this class are binded to jstl view
    //study how the instance values of this class are binded to jstl view
    //study how the instance values of this class are binded to jstl view
    //study how the instance values of this class are binded to jstl view
    //study how the instance values of this class are binded to jstl view
    //study how the instance values of this class are binded to jstl view

    public Todo() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + status +
                '}';
    }
}
