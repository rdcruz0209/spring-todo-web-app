package com.webapplicationprojects.springboot.todowebapp.todo;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Map;

@RequestMapping("/todo")
@SessionAttributes("name")
@Controller
@Slf4j
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUserName("Robert");
        // bound in listTodos.jsp as - <c:forEach items="${todos}" var="todo">
        model.put("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model, Todo todo) {
        String name = (String) model.get("name");
//
//        Todo todo = new Todo(0, name, "", LocalDate.now().plusYears(1), false);
//        todo.setDescription("Default Description"); 2-way binding. pass this setDescription using todo command bean in the view
        todo.setDescription("");
        model.addAttribute("todo", todo);
        log.info("WEBAPP LOG: " + todo.getDescription() + " default description is passed to the model in the view using FBO form tag library");

        return "addTodo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
//            model.addAttribute("errorMessage", errorMessage);
//            used in model to pass error message
            log.info("Field Validation Error " + bindingResult.getFieldError().getDefaultMessage());
            return "addTodo";

        } else {

            String user = (String) model.get("name");
            log.info("WEBAPP LOG: " + todo.getDescription() + " input description is obtained using FBO Todo todo in the parameter field");
            todoService.addTodo(user, todo.getDescription(), todo.getTargetDate(), false);
//        redirect to existing view with the new data to avoid code duplication
            return "redirect:list-todos";
        }
    }


    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        //delete todo with this id
        todoService.deleteTodoById(id);

        return "redirect:list-todos";
    }

//   Update Endpoints

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
//        Todo todo = todoService.findById(id);
//        model.addAttribute("todo", todo);

        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "addTodo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addTodo";
        } else {
            System.out.println(model.size());
            System.out.println("Model attributes:");
            for (Map.Entry<String, Object> entry : model.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            String username = (String) model.get("name");
            todo.setUsername(username);
            log.info("WEBAPP LOG: " + todo.getDescription() + " input description is obtained using FBO Todo todo in the parameter field");
            todoService.updateTodo(todo);
//        redirect to existing view with the new data to avoid code duplication
            return "redirect:list-todos";
        }
    }

}
