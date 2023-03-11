package com.webapplicationprojects.springboot.todowebapp.todo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@RequestMapping("/todo")
@SessionAttributes("name")
@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //     response with

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap map) {

        List<Todo> todos = todoService.findByUserName("Robert");
        map.addAttribute("todos", todos);
        return "listTodos";
    }


}
