package ru.geekbrains.taskListApp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.taskListApp.aspect.TrackUserAction;
import ru.geekbrains.taskListApp.exceptions.TaskNotFoundException;
import ru.geekbrains.taskListApp.model.Task;
import ru.geekbrains.taskListApp.model.Status;
import ru.geekbrains.taskListApp.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

/**
 * Класс для работы с задачами
 */
@Service
public class TaskService {

    /**
     * Внедрение зависимости с TaskRepository.
     */
    @Autowired
    private TaskRepository taskRepository;


    /**
     * Метод получения списка всех задач
     *
     * @return список всех задач
     */
    @TrackUserAction
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Метод добавления новой задачи
     *
     * @param task объект задачи
     * @return добавленную задачу
     */
    @TrackUserAction
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Метод поиска задачи по статусу
     *
     * @param status статус задачи
     * @return список задач с заданным статусом
     */
    public List<Task> findTasksByStatus(Status status) {
        return taskRepository.findTasksByStatus(status);
    }

    /**
     * Метод обновления статуса задачи
     *
     * @param id      уникальный идентификатор
     * @param oldTask объект задачи
     * @return обновленная задача
     */
    public Task updateTaskStatus(Task oldTask, Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
        task.setStatus(oldTask.getStatus());
        return taskRepository.save(task);
    }


    /**
     * Метод обновления статуса задачи
     *
     * @param id         уникальный идентификатор
     * @param statusCode код нового статуса задачи
     * @return обновленная задача
     */
    public Task updateTaskStatusByCode(Long id, String statusCode) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(Status.getStatusFromCode(statusCode));
            return taskRepository.save(task);
        } else {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
    }

    /**
     * Метод удаления задачи
     *
     * @param id уникальный идентификатор
     */
    @TrackUserAction
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

