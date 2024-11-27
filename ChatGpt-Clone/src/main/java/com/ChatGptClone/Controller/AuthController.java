package com.ChatGptClone.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ChatGptClone.Model.User;

@Controller
public class AuthController {
	// Implement user registration logic here

    @PostMapping("/login")
    public String login(User user, Model model) {
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            return "redirect:/dashboard";
        }
        model.addAttribute("error", "Invalid username or password");
        return "login"; // Renders login.html from templates
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Renders register.html from templates
    }
}
