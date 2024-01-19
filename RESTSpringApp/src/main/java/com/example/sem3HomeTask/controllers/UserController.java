package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Контроллер пользователей
 */
@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {

    /*
    Внедрение зависимости с RegistrationService.
     */
    @Autowired
    private RegistrationService service;

    /*
    Метод получения списка всех пользователей.
    @return список всех пользователей.
     */
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    /*
    Метод получения данных о пользователе из тела запроса.
    @param объект пользователя.
    @return данные пользователя для создания.
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.processRegistration(user.getName(), user.getAge(), user.getEmail());
        return "User added from body!";
    }
}
