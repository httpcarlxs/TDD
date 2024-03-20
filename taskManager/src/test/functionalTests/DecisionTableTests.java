package taskManager.src.test.functionalTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import taskManager.src.main.Priority;
import taskManager.src.main.Task;
import taskManager.src.main.TaskManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionTableTests {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        this.taskManager = new TaskManager();
    }

    @Nested
    @DisplayName("Casos de teste para a condição 1")
    class test1Conditions {

        String title = "task1";
        String date = "2024-03-20";
        String description = "desc1";
        Priority priority= Priority.HIGH;

        @Test
        @DisplayName("Create Successful")
        public void testCreate() {
            UUID taskID = taskManager.createTask(title, description, LocalDate.parse(date), priority);
            Map<UUID, Task> tasks = taskManager.getTasks();

            assertEquals(1, tasks.size());
            assertEquals(title, taskManager.getTask(taskID).getTitle());
            assertEquals(description, taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse(date), taskManager.getTask(taskID).getDueDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
        }

        @Test
        @DisplayName("Update Fail")
        public void testUpdateFailOnCondition1() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "task1 atualizada", "desc1", LocalDate.parse("2024-03-21"), Priority.HIGH);
            });

        }

        @Test
        @DisplayName("Delete Fail")
        public void testDeleteFailOnCondition1() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.deleteTask(null);
            });
        }

        @Test
        @DisplayName("Get Fail")
        public void testGetFailOnCondition1() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.getTask(null);
            });
        }

        @Test
        @DisplayName("Set Priority Fail")
        public void testSetPriorityFailOnCondition1() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.setTaskPriority(null, Priority.MEDIUM);
            });
        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition1() {

            UUID taskID = taskManager.createTask(title, description, LocalDate.parse(date), priority);

            List<Task> tasks = taskManager.listTasks();
            System.out.println(tasks);
            LocalDate previousDate = LocalDate.MIN;
            Priority previousPriority = null;

            for (Task task : tasks) {
                LocalDate currentDate = task.getDueDate();
                Priority currentPriority = task.getPriority();
                assertTrue(currentDate.isEqual(previousDate) || currentDate.isAfter(previousDate) ||
                        (currentDate.equals(previousDate) && currentPriority.compareTo(Objects.requireNonNull(previousPriority)) != 0));

                previousDate = currentDate;
                previousPriority = currentPriority;
            }

        }


    }

    @Nested
    @DisplayName("Casos de teste para a condição 2")
    class test2Conditions {

        String title = null;
        String date = "2024-03-20";
        String description = "desc1";
        Priority priority= Priority.HIGH;

        @Test
        @DisplayName("Create Fail")
        public void testCreate() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, LocalDate.parse(date),priority);
            });
        }

        @Test
        @DisplayName("Update Fail")
        public void testUpdateFailOnCondition2() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "task1 atualizada", "desc atualizada", LocalDate.parse("2024-03-21"), Priority.HIGH);
            });

        }

        @Test
        @DisplayName("Delete Fail")
        public void testDeleteFailOnCondition2() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.deleteTask(null);
            });
        }

        @Test
        @DisplayName("Get Fail")
        public void testGetFailOnCondition2() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.getTask(null);
            });
        }

        @Test
        @DisplayName("Set Priority Fail")
        public void testSetPriorityFailOnCondition2() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.setTaskPriority(null, Priority.MEDIUM);
            });
        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition2() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, LocalDate.parse(date),priority);
            });

            List<Task> tasks = taskManager.listTasks();
            System.out.println(tasks);
            LocalDate previousDate = LocalDate.MIN;
            Priority previousPriority = null;

            for (Task task : tasks) {
                LocalDate currentDate = task.getDueDate();
                Priority currentPriority = task.getPriority();
                assertTrue(currentDate.isEqual(previousDate) || currentDate.isAfter(previousDate) ||
                        (currentDate.equals(previousDate) && currentPriority.compareTo(Objects.requireNonNull(previousPriority)) != 0));

                previousDate = currentDate;
                previousPriority = currentPriority;
            }

        }


    }



}
