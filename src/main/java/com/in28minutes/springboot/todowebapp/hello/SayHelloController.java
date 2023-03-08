package com.in28minutes.springboot.todowebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //a specialized @Component
public class SayHelloController {

    // ""say-hello" => "Hello! What are you learning today?

    //http://localhost:8080/say-hello
//    @RequestMapping("say-hello") // @RequestMapping is a Spring MVC annotation
    @RequestMapping("say-hello")
    @ResponseBody //return the String in this method as is
    public String sayHello() {
        return "Hello! What are you learning today?";
    }


    @RequestMapping("say-hello-html")
    @ResponseBody //return the String in this method as is
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<!doctype html>");
        sb.append("<html lang=\"en\">");
        sb.append("<head>");
        sb.append("<meta charset=\"UTF-8\">");
        sb.append("<meta name=\"viewport\"");
        sb.append("content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">");
        sb.append("<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
        sb.append("<title>HTML Page with Body</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("HTML PAGE WITH BODY - CHANGED");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();

    }

    //JSP - Java Server Pages - one of Most popular View  Technology

    //sayHello.jsp
    //""say-hello-jsp" => sayHello.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    @RequestMapping("/say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }


}
