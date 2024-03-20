package taskManager.src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import taskManager.src.main.Priority;
import taskManager.src.main.Task;
import taskManager.src.main.TaskManager;

import java.time.LocalDate;
import java.util.List;
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
        assertEquals(LocalDate.parse("2024-03-05"), taskManager.getTask(taskID).getDueDate());
        assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
    }

    @Test
    public void testDeleteTask() {
        UUID taskID1 = taskManager.createTask("task1", "desc task1",  LocalDate.parse("2024-03-06"), Priority.LOW);
        UUID taskID2 = taskManager.createTask("task2", "desc task2", LocalDate.parse("2024-03-06"), Priority.HIGH);

        Map<UUID,Task> tasks = taskManager.getTasks();
        assertEquals(2, tasks.size());

        taskManager.deleteTask(taskID1);
        assertEquals(1, tasks.size());

        assertEquals("task2", tasks.get(taskID2).getTitle());
        assertEquals("desc task2", tasks.get(taskID2).getDescription());
        assertEquals(LocalDate.parse("2024-03-06"), tasks.get(taskID2).getDueDate());
        assertEquals(Priority.HIGH, tasks.get(taskID2).getPriority());

    }

    @Test
    public void testListTasks() {
        UUID taskID1 = taskManager.createTask("task1", "desc task1",  LocalDate.parse("2024-03-07"), Priority.LOW);
        UUID taskID2 = taskManager.createTask("task2", "desc task2", LocalDate.parse("2024-03-08"), Priority.HIGH);
        UUID taskID3 = taskManager.createTask("task3", "desc task3", LocalDate.parse("2024-03-06"), Priority.MEDIUM);

        List<Task> tasks = taskManager.listTasks();
        LocalDate previousDate = LocalDate.MIN;

        for (Task task : tasks) {
            LocalDate currentDate = task.getDueDate();
            assertTrue(currentDate.isEqual(previousDate) || currentDate.isAfter(previousDate));
            previousDate = currentDate;
        }

        assertEquals("task3", tasks.get(0).getTitle());
        assertEquals("task1", tasks.get(1).getTitle());
        assertEquals("task2", tasks.get(2).getTitle());

    }

    @Test
    public void testOrderListTasks() {

        UUID taskID1 = taskManager.createTask("task1", "desc task1",  LocalDate.parse("2024-03-07"), Priority.LOW);
        UUID taskID2 = taskManager.createTask("task2", "desc task2", LocalDate.parse("2024-03-08"), Priority.HIGH);
        UUID taskID3 = taskManager.createTask("task3", "desc task3", LocalDate.parse("2024-03-06"), Priority.MEDIUM);
        UUID taskID4 = taskManager.createTask("task1", "desc task1",  LocalDate.parse("2024-03-07"), Priority.LOW);
        UUID taskID5 = taskManager.createTask("task2", "desc task2", LocalDate.parse("2024-03-08"), Priority.HIGH);
        UUID taskID6 = taskManager.createTask("task3", "desc task3", LocalDate.parse("2024-03-06"), Priority.MEDIUM);

        List<Task> tasks = taskManager.listTasks();
        System.out.println(tasks);
        LocalDate previousDate = LocalDate.MIN;
        Priority previousPriority = null;

        for (Task task : tasks) {
            LocalDate currentDate = task.getDueDate();
            Priority currentPriority = task.getPriority();
            assertTrue(currentDate.isEqual(previousDate) || currentDate.isAfter(previousDate) ||
                    (currentDate.equals(previousDate) && currentPriority.compareTo(previousPriority) != 0));

            previousDate = currentDate;
            previousPriority = currentPriority;
        }

    }

    @Test
    public void testChangePriority() {
        UUID taskID1 = taskManager.createTask("task1", "desc task1",  LocalDate.parse("2024-03-07"), Priority.LOW);
        taskManager.setTaskPriority(taskID1, Priority.MEDIUM);
        Map<UUID,Task> tasks = taskManager.getTasks();
        assertEquals(Priority.MEDIUM, tasks.get(taskID1).getPriority());
    }
}
