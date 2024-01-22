package com.example.ThymeleafApp.controllers;

import com.example.ThymeleafApp.model.User;
import com.example.ThymeleafApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Контроллер пользователей.
 */
@Controller
public class UserController {

    /**
     * Внедрение зависимости с UserService
     */
    @Autowired
    private UserService userService;

    /**
     * Метод отображения всех пользователей
     * @param model модель для передачи данных в представление
     * @return представление со списком пользователей
     */
    @GetMapping("/users")
    public String showUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    /**
     * Метод отображения всех пользователей и их количества
     * @param model модель для передачи данных в представление
     * @param user объект пользователя
     * @return представление со списком пользователей и их количеством
     */
    @PostMapping("/users")
    public String addUser(Model model, User user) {
        userService.addUser(user);
        model.addAttribute("totalNumber", userService.getAllUsers().size());
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
}
