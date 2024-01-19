package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
Контроллер задач.
 */
@RestController
@RequestMapping("/tasks") //localhost:8080/tasks
public class TaskController {

    /*
    Внедрение зависимости с DataProcessingService.
     */
    @Autowired
    private DataProcessingService service;

    /*
    Метод получения всех задач.
    @return список все задач.
     */
    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /*
    Метод получения отсортированного списка пользователей.
    @return отсортированный список
     */
    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /*
    Метод получения отфильтрованного списка пользователей.
    @param возраст пользователей.
    @return отфильтрованный список.
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    /*
    Метод получения среднего возраста пользователей.
    @return средний возраст.
     */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
