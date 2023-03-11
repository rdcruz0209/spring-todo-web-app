package com.webapplicationprojects.springboot.todowebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "Robert", "Learn AWS",
                LocalDate.now().plusYears(1), false));

        todos.add(new Todo(2, "Robert", "Learn Spring",
                LocalDate.now().plusYears(1), false));

        todos.add(new Todo(3, "Robert", "Learn React",
                LocalDate.now().plusYears(1), false));


    }

    public List<Todo> findByUserName(String username) {
        return todos;
    }
}
