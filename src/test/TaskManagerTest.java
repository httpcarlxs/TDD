package src.test;

import org.junit.Test;
import src.main.Priority;
import src.main.Task;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

public class TaskManagerTest {]

    @Test
    public void testCreateTask() {
        UUID taskID = this.taskManager.createTask("task1", "desc task1", "2024-03-06", Priority.HIGH);
        Map<UUID, Task> tasks = this.taskManager.getTasks();
        assertEquals(1, tasks.size());
        assertEquals("task1", this.taskManager.getTask(taskID).getTitle());
        assertEquals("desc task1", this.taskManager.getTask(taskID).getDescription());
        assertEquals(LocalDate.parse("2024-03-06"), this.taskManager.getTask(taskID).getDate());
        assertEquals(Priority.HIGH, this.taskManager.getTask(taskID).getPriority());
    }
}
