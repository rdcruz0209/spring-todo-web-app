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
        todos.add(new Todo(++todosCount, "Robert", "Get AWS Certified",
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
