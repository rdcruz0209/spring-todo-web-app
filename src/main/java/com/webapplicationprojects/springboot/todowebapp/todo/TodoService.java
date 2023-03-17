package com.webapplicationprojects.springboot.todowebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "Robert", "Get AWS Certified 1",
                LocalDate.now().plusYears(1), false));

        todos.add(new Todo(++todosCount, "Robert", "Learn Spring 1",
                LocalDate.now().plusYears(1), false));

        todos.add(new Todo(++todosCount, "Robert", "Learn React 1",
                LocalDate.now().plusYears(1), false));


    }

    public List<Todo> findByUserName(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean status) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, status);
        todos.add(todo);
    }

    public void deleteTodoById(int id) {
        todos.removeIf(todos -> todos.getId() == id);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(Todo todo) {
        deleteTodoById(todo.getId());
        todos.add(todo);

    }
}
