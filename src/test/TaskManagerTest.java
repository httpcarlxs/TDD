package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.main.Priority;
import src.main.Task;
import src.main.TaskManager;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

public class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        this.taskManager = new TaskManager();
    }

    @Test
    public void testCreateTask() {
        UUID taskID = this.taskManager.createTask("task1", "desc task1", LocalDate.parse("2024-03-05"), Priority.HIGH);
        Map<UUID, Task> tasks = this.taskManager.getTasks();
        assertEquals(1, tasks.size());
        assertEquals("task1", this.taskManager.getTask(taskID).getTitle());
        assertEquals("desc task1", this.taskManager.getTask(taskID).getDescription());
        assertEquals(LocalDate.parse("2024-03-05"), this.taskManager.getTask(taskID).getDueDate());
        assertEquals(Priority.HIGH, this.taskManager.getTask(taskID).getPriority());
    }

    @Test
    public void testUpdateTask() {
        UUID taskID = this.taskManager.createTask("task1", "desc task1", LocalDate.parse("2024-03-05"), Priority.HIGH);
        taskManager.updateTask(taskID, "Task 1 atualizada", "desc task 1 atualziada", LocalDate.parse("2024-03-05"), Priority.HIGH);
        assertEquals("Task 1 atualizada", taskManager.getTask(taskID).getTitle());
        assertEquals("desc task 1 atualziada", taskManager.getTask(taskID).getDescription());
        assertEquals(LocalDate.parse("2024-03-05"), taskManager.getTask(taskID).getDuoDate());
        assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
    }
}
