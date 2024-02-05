package ru.geekbrains.taskListApp.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.taskListApp.model.Task;
import ru.geekbrains.taskListApp.model.Status;
import ru.geekbrains.taskListApp.service.TaskService;

import java.util.List;

/**
 * Контроллер задач.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    /**
     * Внедрение зависимости с TaskService.
     */
    @Autowired
    private TaskService service;

    /**
     * Метод добавления новой задачи
     * @param task объект задачи
     * @return добавленную задачу
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    /**
     * Метод получения списка всех задач
     * @return список всех задач
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    /**
     * Метод поиска задачи по статусу
     * @param status статус задачи
     * @return список задач с заданным статусом
     */
    @GetMapping("/status/{status}")
    public List<Task> findTasksByStatus(@PathVariable Status status) {
        return service.findTasksByStatus(status);
    }

    /**
     * Метод обновления статуса задачи, переданного в теле запроса
     * @param id уникальный идентификатор
     * @param task объект задачи
     * @return обновленная задача
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTaskStatus(task,id);
    }

    /**
     * Метод обновления статуса задачи, переданного в адресе запроса кодом
     * @param id уникальный идентификатор
     * @param statusCode код статуса задачи
     * @return обновленная задача
     */
    @PutMapping("/{id}/{statusCode}")
    public Task updateTaskStatusByCode(@PathVariable Long id, @PathVariable String statusCode) {
        return service.updateTaskStatusByCode(id, statusCode);
    }

    /**
     * Метод удаления задачи
     * @param id уникальный идентификатор
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
