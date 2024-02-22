package ru.geekbrains.taskList.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Класс задача
 */
@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(name = "status")
    private Status status;
    @Column(name = "created")
    private LocalDateTime createdAt;


    /**
     * Конструктор без аргументов
     * При создании статус устанавливается как "NOT_STARTED"
     * и указывается время создания
     */
    public Task() {
        status = Status.NOT_STARTED;
        createdAt = LocalDateTime.now();
    }

    /**
     * Конструктор с аргументами
     * @param id уникальный идентификатор
     * @param description Описание задачи
     */
    public Task(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}
