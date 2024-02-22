package ru.geekbrains;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.geekbrains.taskList.exceptions.TaskNotFoundException;
import ru.geekbrains.taskList.model.Task;
import ru.geekbrains.taskList.repository.TaskRepository;
import ru.geekbrains.taskList.service.TaskService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Класс для модульного тестирования
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TaskServiceTest {

    /**
     * Создание и внедрение макета
     */
    @Mock
    private TaskRepository repository;

    /**
     * Создание экземпляра класса
     */
    @InjectMocks
    private TaskService service;

    /**
     * Тестирование метода создания задачи
     */
    @Test
    public void addTaskTest() {
        Task task = new Task();
        task.setId(1L);
        task.setDescription("Go to work at 18P.M.");

        given(repository.save(task)).willReturn(Optional.of(task).orElseThrow());

        service.addTask(task);

        verify(repository).save(task);
    }

    /**
     * Тестирование исключения в методе обновления задачи
     */
    @Test
    public void updateTaskStatusTest() {
        Task task = new Task();
        task.setId(1L);
        task.setDescription("Go to work at 18P.M.");

        given(repository.findById(1L)).willReturn(Optional.of(task));

        given(repository.findById(2L)).willReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class,
                () -> service.updateTaskStatus(task, 2L));

        verify(repository, never()).save(task);
    }
}
