package ru.geekbrains.taskListApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.taskListApp.model.Task;
import ru.geekbrains.taskListApp.repository.TaskRepository;
import ru.geekbrains.taskListApp.service.TaskService;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Класс для интеграционного тестирования
 */
@SpringBootTest
class TaskListAppApplicationTests {

	@MockBean
	private TaskRepository repository;

	@Autowired
	private TaskService service;

	@Test
	public void addTaskTest() {
		Task task = new Task();
		task.setId(1L);
		task.setDescription("Go to work at 18P.M.");

		given(repository.save(task)).willReturn(Optional.of(task).orElseThrow());

		service.addTask(task);

		verify(repository).save(task);
	}
}
