package ru.geekbrains.webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.webclient.model.User;
import ru.geekbrains.webclient.service.UserService;

@Controller
public class UserController {

    @Autowired
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public String getAll(Model model) {
        model.addAttribute("users", service.getAll());
        return "home";
    }
//
//    @PostMapping("/users")
//    public String createUser(Model model, User user) {
//        service.createUser(user);
//        model.addAttribute("users", service.getAll());
//        return "users";
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        service.deleteUser(id);
//    }
}
