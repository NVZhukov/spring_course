package ru.geekbrains.taskList.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.taskList.model.Task;
import ru.geekbrains.taskList.model.Status;
import ru.geekbrains.taskList.service.FileGateway;
import ru.geekbrains.taskList.service.TaskService;

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
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        return new ResponseEntity<>(service.addTask(task), HttpStatus.OK);
    }

    /**
     * Метод получения списка всех задач
     * @return список всех задач
     */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(service.getAllTasks(), HttpStatus.OK);
    }

    /**
     * Метод поиска задачи по статусу
     * @param status статус задачи
     * @return список задач с заданным статусом
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> findTasksByStatus(@PathVariable Status status) {
        return new ResponseEntity<>(service.findTasksByStatus(status), HttpStatus.OK);
    }

    /**
     * Метод обновления статуса задачи, переданного в теле запроса
     * @param id уникальный идентификатор
     * @param task объект задачи
     * @return обновленная задача
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return new ResponseEntity<>(service.updateTaskStatus(task,id), HttpStatus.OK);
    }

    /**
     * Метод обновления статуса задачи, переданного в адресе запроса кодом
     * @param id уникальный идентификатор
     * @param statusCode код статуса задачи
     * @return обновленная задача
     */
    @PutMapping("/{id}/{statusCode}")
    public ResponseEntity<Task> updateTaskStatusByCode(@PathVariable Long id, @PathVariable String statusCode) {
        return new ResponseEntity<>(service.updateTaskStatusByCode(id, statusCode), HttpStatus.OK);
    }

    /**
     * Метод удаления задачи
     * @param id уникальный идентификатор
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
