package com.webapplicationprojects.springboot.todowebapp.todo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/todo")
@SessionAttributes("name")
@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap map) {

        List<Todo> todos = todoService.findByUserName("Robert");
        map.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showNewTodoPage() {
        List<Todo> todos = todoService.findByUserName("Robert");
        return "addTodo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addNewTodo(@RequestParam(required = false) String description, ModelMap model) {
        String user = (String) model.get("name");
        todoService.addTodo(user, description, LocalDate.now().plusYears(1), false);
//redirect to existing view with the new data to avoid code duplication
        return "redirect:list-todos";
    }


}
