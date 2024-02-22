package ru.geekbrains.taskList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.taskList.model.Task;
import ru.geekbrains.taskList.model.Status;

import java.util.List;

/**
 * Интерфейс для упраления репозиторием задач
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Создание пользовательского запроса выбора задач по статусу
     * @param status статус задачи
     * @return список задач с указанным статусом
     */
    @Query(value = "SELECT * FROM tasks t WHERE t.status = :status",
            nativeQuery = true)
    List<Task> findTasksByStatus(@Param("status") Status status);

}
