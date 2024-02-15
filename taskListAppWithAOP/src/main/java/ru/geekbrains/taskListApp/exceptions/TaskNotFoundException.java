package ru.geekbrains.taskListApp.exceptions;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(String s) {
        super(s);
    }
}
