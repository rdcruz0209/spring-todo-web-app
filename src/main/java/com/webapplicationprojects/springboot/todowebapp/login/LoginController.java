package com.webapplicationprojects.springboot.todowebapp.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
@Slf4j // look for external monitoring for logger such as : Elasticsearch, Logstash, and Kibana
public class LoginController {

    private final AuthenticationService authenticationService;

    @Autowired
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    //    login view
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goToLoginPage() {
        return "login";
    }

    //authentication logic
    // name - Robertdev
    // password - possward

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam(required = false) String name,
                                  String password, String incorrectPasswordResponse, ModelMap model) {

        if (authenticationService.authenticate(name, password)) {

            model.put("name", name);
            return "welcome";
        } else {
            incorrectPasswordResponse = "Incorrect username or password. Please try again.";
            model.put("incorrectPasswordResponse", incorrectPasswordResponse);
            return "login";
        }
    }


    // /http://localhost:8080/login?name=Ranga
    //Model
//    @GetMapping("/login")
//    public String goToLoginPage(@RequestParam(defaultValue = "Claire!", required = false) String name,
//                                ModelMap model) {
//        log.info("SLF4J LOG: Accessed login.jsp through Get Method");
////        log.info(log.getClass().toString());
////        logger.info(logger.getClass().toString());
//        log.debug("Request Param is {}", name);
//        log.info("Print this at info level: {}, {}, {}", "first place holder", "second place holder", name);
//
//        model.put("name", name);
//
//        System.out.println(name);
//        return "login";
//    }

    //   in this method we used @RequestParam
    @RequestMapping("/loginwithname")
    public String anotherLoginPage(@RequestParam(defaultValue = "Robert", required = false) String name,
                                   ModelMap model) {
        log.info("SLF4J LOG: Accessed login.jsp through Get Method");
        log.debug("Request Param is {}", name);
        log.info("Print this at info level: {}, {}, {}", "first place holder", "second place holder", name);

        model.put("name", name);

        System.out.println(name);
        return "login";
    }

}
