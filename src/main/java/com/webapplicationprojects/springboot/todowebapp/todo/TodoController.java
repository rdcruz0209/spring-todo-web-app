package com.webapplicationprojects.springboot.todowebapp.todo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String listAllTodos(ModelMap model) {

        List<Todo> todos = todoService.findByUserName("Robert");
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model, Todo todo) {
        String name = (String) model.get("name");
//
//        Todo todo = new Todo(0, name, "", LocalDate.now().plusYears(1), false);
        model.addAttribute("todo", todo);
        return "addTodo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, Todo todo) {
        String user = (String) model.get("name");
        todoService.addTodo(user, todo.getDescription(), LocalDate.now().plusYears(1), false);
//        redirect to existing view with the new data to avoid code duplication
        return "redirect:list-todos";
    }

}
