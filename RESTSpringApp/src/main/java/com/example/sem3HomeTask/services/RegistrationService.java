package com.example.sem3HomeTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    //Метод processRegistration
    public void processRegistration(String name, int age, String email) {
        dataProcessingService.addUserToList(userService.createUser(name, age, email));
    }
}
