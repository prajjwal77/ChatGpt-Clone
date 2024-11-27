package com.ChatGptClone.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@Controller
public class ChatController {

    @GetMapping("/")
    public String homePage() {
        return "home"; // Renders home.html from templates
    }

    @PostMapping("/chat")
    @ResponseBody
    public String handleChat(@RequestParam("message") String message) {
        return "You said: " + message + ". Here's a bot response!";
    }
}
