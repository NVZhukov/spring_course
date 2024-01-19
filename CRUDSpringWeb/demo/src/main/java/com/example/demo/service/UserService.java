package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Класс для работы с пользователями
 */
@Service
public class UserService {
    /*
    Объект репозитория для работы с БД.
     */
    private final UserRepository userRepository;

    /*
    Конструктор класса
    @param репозиторий пользователей
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }

    /*
    Метод получения всех пользователей из БД.
    @return список пользователей
    */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /*
    Метод сохранения пользователя в БД.
    @param User объект пользователя
    @return User с id
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /*
    Метод удаления пользователя из БД.
    @param уникальный идентификатор
     */
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    /*
    Метод обновления данных пользователя в БД.
    @param User с обновленными данными
     */
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
}
