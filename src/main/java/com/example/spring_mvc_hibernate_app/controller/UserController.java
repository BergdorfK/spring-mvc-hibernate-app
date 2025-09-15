package com.example.spring_mvc_hibernate_app.controller;

import com.example.spring_mvc_hibernate_app.entity.User;
import com.example.spring_mvc_hibernate_app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("email") String email) {
        service.saveUser(new User(name, email));
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("email") String email) {
        User user = service.getUserById(id);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            service.saveUser(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id) {
        service.deleteUser(id);
        return "redirect:/users";
    }

}