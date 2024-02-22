package ru.geekbrains.taskList.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.geekbrains.taskList.service.FileGateway;

@Component
public class TaskUpdatedListener implements ApplicationListener<TaskUpdatedEvent> {

    @Autowired
    private FileGateway fileGateway;

    @Override
    public void onApplicationEvent(TaskUpdatedEvent event) {
        fileGateway.writeToFile(event.getTask().getId() + ".txt", event.getTask().toString());
    }
}
