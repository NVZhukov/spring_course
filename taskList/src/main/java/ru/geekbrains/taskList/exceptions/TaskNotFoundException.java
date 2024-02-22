package ru.geekbrains.taskList.exceptions;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(String s) {
        super(s);
    }
}
