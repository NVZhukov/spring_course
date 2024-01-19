package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Класс для управления хранилищем пользователей.
 */
@Service
public class DataProcessingService {

    /*
    Геттер UserRepository.
     */
    public UserRepository getRepository() {
        return repository;
    }

    /*
    Внедрение зависимости с UserRepository.
     */
    @Autowired
    private UserRepository repository;


    /*
    Метод сортировки списка пользователей по возрасту.
    @param список пользователей.
    @return отсортированный список пользователей.
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /*
    Метод фильтрации списка пользователей по возрасту.
    @param список пользователей.
    @param возраст
    @return отфильтрованный список пользователей.
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /*
    Метод получения среднего возраста пользователей.
    @param список пользователей.
    @return средний возраст.
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /*
    Метод добавления пользователя в хранилище.
     */
    public void addUserToList(User user) {
        repository.getUsers().add(user);
    }
}
