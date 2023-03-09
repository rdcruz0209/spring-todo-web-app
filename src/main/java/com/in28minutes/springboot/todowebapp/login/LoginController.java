package com.in28minutes.springboot.todowebapp.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
@Slf4j // look for external monitoring for logger such as : Elasticsearch, Logstash, and Kibana
public class LoginController {


    // /http://localhost:8080/login?name=Ranga
    //Model
    @GetMapping("/login")
    public String goToLoginPage(@RequestParam(defaultValue = "Claire!", required = false) String name,
                                ModelMap model) {
        log.info("SLF4J LOG: Accessed login.jsp through Get Method");
//        log.info(log.getClass().toString());
//        logger.info(logger.getClass().toString());
        log.debug("Request Param is {}", name);
        log.info("Print this at info level: {}, {}, {}", "first place holder", "second place holder", name);

        model.put("name", name);

        System.out.println(name);
        return "login";
    }

    @GetMapping("/login/{name}")
    public String anotherLoginPage(@PathVariable String name,
                                   ModelMap model) {
        log.info("SLF4J LOG: Accessed login.jsp through Get Method");
//        log.info(log.getClass().toString());
//        logger.info(logger.getClass().toString());
        log.debug("Request Param is {}", name);
        log.info("Print this at info level: {}, {}, {}", "first place holder", "second place holder", name);

        model.put("name", name);

        System.out.println(name);
        return "login";
    }

}
