package com.webapplicationprojects.springboot.todowebapp.todo;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/todo")
@Slf4j
public class TodoControllerJpa {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoControllerJpa(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping("/list-todos")
    public ModelAndView listAllTodos(ModelMap model, ModelAndView mav) {
        String username = getLoggedInUserName(model);
        // bound in listTodos.jsp as - <c:forEach items="${todos}" var="todo">
        List<Todo> todos = todoRepository.findByUsername(username);
//        model.addAttribute("todos", todos);
//        printAllModelMapAttributes(model, "listAllTodos Post");
//        tested ModelAndView implementation. Will work the same as ModelMap but in this method the return type is of type ModelAndView
        mav.addObject("todos", todos);
        mav.setViewName("listTodos");
        return mav;
//        return "listTodos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model, Todo todo) {
//        todo.setDescription("Default Description"); 2-way binding. pass this setDescription using todo command bean in the view
        todo.setDescription("");
        model.addAttribute("todo", todo);
        log.info("WEBAPP LOG: " + todo.getDescription() + " default description is passed to the model in the view using FBO form tag library");
        printAllModelMapAttributes(model, "showNewTodo GET");

        return "addTodo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        printAllModelMapAttributes(model, "Add New Todo Post");
        if (bindingResult.hasErrors()) {
            log.info("Field Validation Error " + Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return "addTodo";
        } else {
            // for repository the recommended method is to populate the entity object with required values
//            before invoking the repository.save(entityObject) method
            String user = getLoggedInUserName(model);
            todo.setUsername(user);
            log.info("WEBAPP LOG: " + todo.getDescription() + " input description is obtained using FBO Todo todo in the parameter field");
            System.out.println(todo.getTargetDate());
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
        Todo todo = todoRepository.findByUsername("Robert").
                stream().filter((a) -> a.getId() == id).
                findFirst().orElse(null);
        model.addAttribute("todo", todo);
        assert todo != null;
        System.out.println(todo.getUsername());
        printAllModelMapAttributes(model, "showUpdateTodoPage Get");
        return "addTodo";

    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        System.out.println(todo.getUsername());
        System.out.println(todo.getId());
        System.out.println(todo.getDescription());
        System.out.println(todo.getTargetDate());
        if (bindingResult.hasErrors()) {
            return "addTodo";
        } else {
            printAllModelMapAttributes(model, "update Todo Post");
            String username = getLoggedInUserName(model);
            System.out.println(username);
            todo.setUsername(username);
            todoRepository.save(todo);
            log.info("WEBAPP LOG: " + todo.getDescription() + " input description is obtained using FBO Todo todo in the parameter field");
//            todoService.updateTodo(todo);
//        redirect to existing view with the new data to avoid code duplication
            printAllModelMapAttributes(model, "updateTodo POST");

            return "redirect:list-todos";
        }
    }

    private static String getLoggedInUserName(ModelMap model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    private static void printAllModelMapAttributes(ModelMap model, String methodName) {
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
