package com.example.sem3HomeTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
Класс для управления регистрацией.
 */
@Service
public class RegistrationService {


    /*
    Геттер DataProcessingService.
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /*
    Внедрение зависимости с DataProcessingService, UserService, NotificationService.
     */
    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    /*
    Метод регистрации нового пользователя.
     */
    public void processRegistration(String name, int age, String email) {
        dataProcessingService.addUserToList(userService.createUser(name, age, email));
    }
}
