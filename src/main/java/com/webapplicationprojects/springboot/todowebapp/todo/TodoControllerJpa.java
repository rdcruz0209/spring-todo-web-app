package com.webapplicationprojects.springboot.todowebapp.todo;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/todo")
@SessionAttributes("username")
@Controller
@Slf4j
public class TodoControllerJpa {

    private final TodoRepository todoRepository;
    private final TodoService todoService;

    @Autowired
    public TodoControllerJpa(TodoRepository todoRepository, TodoService todoService) {
        this.todoRepository = todoRepository;
        this.todoService = todoService;
    }

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        printAllModelMapModels(model, "listAllTodos Post");
        String username = getLoggedInUserName(model);
        // bound in listTodos.jsp as - <c:forEach items="${todos}" var="todo">
        List<Todo> todos = todoRepository.findByUsername(username);
        model.put("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model, Todo todo) {
        printAllModelMapModels(model, "showNewTodo GET");
        System.out.println(todo.getUsername());


        String s = "hello";
        s.substring(0, 2);
//        String name = (String) model.get("name");
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
        printAllModelMapModels(model, "Add New Todo Post");
        if (bindingResult.hasErrors()) {
            log.info("Field Validation Error " + bindingResult.getFieldError().getDefaultMessage());
            return "addTodo";
        } else {

            // for repository the recommended method is to populate the entity object with required values
//            before invoking the repository.save(entityObject) method

            String user = getLoggedInUserName(model);
            todo.setUsername(user);
            log.info("WEBAPP LOG: " + todo.getDescription() + " input description is obtained using FBO Todo todo in the parameter field");
//            todoService.addTodo(todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.getStatus());
//            redirect to existing view with the new data to avoid code duplication
            todoRepository.save(todo);
            return "redirect:list-todos";
        }
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        //delete todo with this id
        Todo todoToBeDeleted = todoRepository.getReferenceById(id);
        log.info("Todo to be deleted = " + todoToBeDeleted.getId() + " " + todoToBeDeleted.getDescription());
        todoRepository.deleteById(id);
//        todoService.deleteTodoById(id);
        return "redirect:list-todos";
    }

//   Update Endpoints

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        printAllModelMapModels(model, "showUpdateTodoPage Get");
//        Todo todo = todoService.findById(id);
//        model.addAttribute("todo", todo);
        Todo todo = todoRepository.findById(id).orElse(null);
        model.addAttribute("todo", todo);
        return "addTodo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        printAllModelMapModels(model, "updateTodo POST");
        if (bindingResult.hasErrors()) {
            return "addTodo";
        } else {
            System.out.println("username from model: " + model.getAttribute("username"));
            printAllModelMapModels(model, "update Todo Post");
            String username = getLoggedInUserName(model);
            System.out.println(username);
            todo.setUsername(username);
            todoRepository.save(todo);
            log.info("WEBAPP LOG: " + todo.getDescription() + " input description is obtained using FBO Todo todo in the parameter field");
//            todoService.updateTodo(todo);
//        redirect to existing view with the new data to avoid code duplication
            return "redirect:list-todos";
        }
    }

    private static String getLoggedInUserName(ModelMap model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    private static void printAllModelMapModels(ModelMap model, String methodName) {
        System.out.println("=========================================================");
        System.out.println("Model attributes: " + methodName);
        System.out.println("attribute count: " + model.size());
        for (Map.Entry<String, Object> entry : model.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        System.out.println("=========================================================");
    }


}
