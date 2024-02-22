package ru.geekbrains.taskList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.taskList.model.Task;
import ru.geekbrains.taskList.repository.TaskRepository;
import ru.geekbrains.taskList.service.TaskService;

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
