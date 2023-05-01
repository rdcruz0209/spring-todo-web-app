package com.webapplicationprojects.springboot.todowebapp.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
@Slf4j // look for external monitoring for logger such as : Elasticsearch, Logstash, and Kibana
public class WelcomeController {
    //    login view
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model) {
        model.put("username", getLoggedinUserName());
        return "welcome";
    }

    private String getLoggedinUserName() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        return authentication.getName();
    }
}
