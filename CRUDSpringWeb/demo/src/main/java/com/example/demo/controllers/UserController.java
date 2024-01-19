package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*
Контроллер пользователей.
 */
@Controller
public class UserController {
    /*
    Объект сервиса для работы с пользователями.
     */
    private final UserService userService;

    /*
    Конструктор класса
    @param сервис пользователей.
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
    Метод получения всех пользователей.
    @param модель для передачи данных в представление.
    @return представление со списком пользователей.
     */
    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "user-list";
    }

    /*
    Метод создания нового пользователя.
    @param объект пользователя.
    @return представление для создания пользователя.
     */
    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    /*
    Метод получения данных о новом пользователе с формы представления.
    @param объект пользователя.
    @return перенаправление на страницу со списком пользователей.
     */
    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    /*
    Метод удаления пользователя по уникальному идентификатору.
    @param уникальный идентификатор.
    @return перенаправление на страницу со списком пользователей.
     */
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    /*
    Метод изменения данных пользователя.
    @param уникальный идентификатор.
    @param модель для передачи данных в представление.
    @return представление для изменения данных
     */
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
