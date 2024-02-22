package ru.geekbrains.taskList.utils;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.geekbrains.taskList.model.Task;

@Getter
public class TaskUpdatedEvent extends ApplicationEvent {
    private Task task;


    public TaskUpdatedEvent(Object source, Task task) {
        super(source);
        this.task = task;
    }
}
