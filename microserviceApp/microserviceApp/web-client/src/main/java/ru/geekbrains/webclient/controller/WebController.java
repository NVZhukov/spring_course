package ru.geekbrains.webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.webclient.model.User;
import ru.geekbrains.webclient.service.UserService;

import java.util.List;

@Controller
//@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public String getAll(Model model) {
        List<User> users = service.getUserList();
        model.addAttribute("users", users);
        return "users";
    }

//    @PostMapping
//    public String createUser(Model model, User user) {
//        service.save(user.getId(), user.getName(), user.getLastName(), user.getEmail());
//        model.addAttribute("users", service.getUserList());
//        return "users";
//    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.getNote(id);
    }
}
