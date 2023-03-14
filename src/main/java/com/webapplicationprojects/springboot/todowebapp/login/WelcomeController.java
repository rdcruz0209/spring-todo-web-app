package com.webapplicationprojects.springboot.todowebapp.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
@Slf4j // look for external monitoring for logger such as : Elasticsearch, Logstash, and Kibana
public class WelcomeController {
    ;

    //    login view
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model) {
        model.put("name", "Robert");

        return "welcome";
    }

}
