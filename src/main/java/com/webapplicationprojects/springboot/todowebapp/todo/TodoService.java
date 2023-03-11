package com.webapplicationprojects.springboot.todowebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "Robert", "Learn AWS",
                LocalDate.now().plusYears(1), false));

        todos.add(new Todo(++todosCount, "Robert", "Learn Spring",
                LocalDate.now().plusYears(1), false));

        todos.add(new Todo(++todosCount, "Robert", "Learn React",
                LocalDate.now().plusYears(1), false));


    }

    public List<Todo> findByUserName(String username) {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean status) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, status);
        todos.add(todo);
    }
}
