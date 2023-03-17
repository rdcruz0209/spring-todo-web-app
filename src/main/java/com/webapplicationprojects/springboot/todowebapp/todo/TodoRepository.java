package com.webapplicationprojects.springboot.todowebapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@SessionAttributes({"username", "todo"})
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    public List<Todo> findByUsername(String username);

}
