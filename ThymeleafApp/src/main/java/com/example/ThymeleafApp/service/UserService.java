package com.example.ThymeleafApp.service;

import com.example.ThymeleafApp.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с пользователями
 */
@Service
public class UserService {

    /**
     * Инициализация списка пользователей
     */
    List<User> users = new ArrayList<>();

    /**
     * Метод добавления пользователя в список
     * @param user объект пользователя
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Метод получения списка пользователей
     * @return список всех пользователей
     */
    public List<User> getAllUsers() {
        return users;
    }
}
