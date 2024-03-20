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

    @Nested
    @DisplayName("Casos de testes para a condição 3")
    class test3Conditions {

        String title = "task1";
        String date = "2024-03-20";
        String description = null;
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
        public void testUpdateFailOnCondition3() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "task1 atualizada", "dec1", LocalDate.parse("2024-03-21"), Priority.HIGH);
            });
        }

        @Test
        @DisplayName("Delete Fail")
        public void testDeleteFailOnCondition3() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.deleteTask(null);
            });
        }

        @Test
        @DisplayName("Get Fail")
        public void testGetFailOnCondition3() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.getTask(null);
            });
        }

        @Test
        @DisplayName("Set Priority Fail")
        public void testSetPriorityFailOnCondition3() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.setTaskPriority(null, Priority.MEDIUM);
            });
        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition3() {

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

    @Nested
    @DisplayName("Casos de testes para a condição 4")
    class test4Conditions {

        String title = "task1";
        String date = "2024-03-20";
        String description = "desc1";
        Priority priority= null;

        @Test
        @DisplayName("Create Fail")
        public void testCreate() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, LocalDate.parse(date),priority);
            });
        }

        @Test
        @DisplayName("Update Fail")
        public void testUpdateFailOnCondition4() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "task1 atuazali", "desc1 atual", LocalDate.parse("2024-03-22"), Priority.HIGH);
            });
        }

        @Test
        @DisplayName("Delete Fail")
        public void testDeleteFailOnCondition4() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.deleteTask(null);
            });
        }

        @Test
        @DisplayName("Get Fail")
        public void testGetFailOnCondition4() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.getTask(null);
            });
        }

        @Test
        @DisplayName("Set Priority Fail")
        public void testSetPriorityFailOnCondition4() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.setTaskPriority(null, Priority.MEDIUM);
            });
        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition4() {

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

    @Nested
    @DisplayName("Casos de teste para a condição 5")
    class test5Conditions {

        String title = "task1";
        String date = null;
        String description = "desc123";
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
        public void testUpdateFailOnCondition5() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "task1 atualizao ", "desc34", LocalDate.parse("2024-03-24"), Priority.HIGH);
            });
        }

        @Test
        @DisplayName("Delete Fail")
        public void testDeleteFailOnCondition5() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.deleteTask(null);
            });
        }

        @Test
        @DisplayName("Get Fail")
        public void testGetFailOnCondition5() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.getTask(null);
            });
        }

        @Test
        @DisplayName("Set Priority Fail")
        public void testSetPriorityFailOnCondition5() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.setTaskPriority(null, Priority.MEDIUM);
            });
        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition5() {

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

    @Nested
    @DisplayName("Casos de teste para a condição 6")
    class test6Conditions {

        String title = "task1";
        String date = "2024-03-20";
        String description = "desc625"  ;
        Priority priority= Priority.HIGH;

        @Test
        @DisplayName("Create Successful")
        public void testCreateSuccessfulOnCondition6() {

            UUID taskID = taskManager.createTask(title, description, LocalDate.parse(date), priority);
            Map<UUID,Task> tasks = taskManager.getTasks();

            assertEquals(1, tasks.size());
            assertEquals(title, taskManager.getTask(taskID).getTitle());
            assertEquals(description, taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse(date), taskManager.getTask(taskID).getDueDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
        }

        @Test
        @DisplayName("Update Successful")
        public void testUpdateSuccessfulOnCondition6() {

            UUID taskID = taskManager.createTask(title, description, LocalDate.parse(date), priority);
            taskManager.updateTask(taskID, "task1 atualziada", "desc1 atual", LocalDate.parse("2024-03-27",) Priority.HIGH);
            assertEquals("task1 atualziada", taskManager.getTask(taskID).getTitle());
            assertEquals("desc1 atual", taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse("2024-03-27"), taskManager.getTask(taskID).getDueDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());

        }

        @Test
        @DisplayName("Delete Successful")
        public void testDeleteSuccessfulOnCondition6l() {
            UUID taskID = taskManager.createTask(title, description, LocalDate.parse(date), priority);

            taskManager.deleteTask(taskID);
            assertEquals(0, taskManager.getTasks().size());
        }

        @Test
        @DisplayName("Get Successful")
        public void testGetSuccessfulOnCondition6() {

            UUID taskID = taskManager.createTask(title, description, LocalDate.parse(date), Priority.HIGH);

            assertEquals(title, taskManager.getTask(taskID).getTitle());
            assertEquals(description, taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse(date), taskManager.getTask(taskID).getDueDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
            assertEquals(1, taskManager.getTasks().size());

        }

        @Test
        @DisplayName("Set Priority Successful")
        public void testSetPrioritySuccessfulOnCondition6() {

            UUID taskID0 = taskManager.createTask("task1", "desc1", LocalDate.parse("2024-03-25"), Priority.LOW);
            taskManager.setTaskPriority(taskID0, Priority.MEDIUM);
            Map<UUID,Task> tasks = taskManager.getTasks();
            assertEquals(Priority.MEDIUM, tasks.get(taskID0).getPriority());

        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition6() {

            UUID taskID0 = taskManager.createTask("task1", "desc1", LocalDate.parse("2024-03-25"), Priority.LOW);

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
    @DisplayName("Casos de teste para a condição 7")
    class test7Conditions {

        String title = null;
        String date = null;
        String description = null;
        Priority priority= null;


        @Test
        @DisplayName("Create Fail")
        public void testCreateFailOnCondition7() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, LocalDate.parse(date), priority);
            });
        }

        @Test
        @DisplayName("Update Fail")
        public void testUpdateFailOnCondition7() {

            UUID taskID0 = taskManager.createTask("task1", "desc1", LocalDate.parse("2024-03-25"), Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID0, title, description, LocalDate.parse(date), priority);
            });

        }

        @Test
        @DisplayName("Delete Successful")
        public void testDeleteFailOnCondition7() {
            UUID taskID0 = taskManager.createTask("task1", "desc2", LocalDate.parse("2024-03-25"), Priority.LOW);

            taskManager.deleteTask(taskID0);
            assertEquals(0, taskManager.getTasks().size());

        }

        @Test
        @DisplayName("Get Successful")
        public void testGetSuccessfulOnCondition7() {

            String title1 = "task1";
            String description1 = "desc1";
            String date1 = "2024-03-25";
            Priority priority1 = Priority.LOW;

            UUID taskID0 = taskManager.createTask(title1, description1, LocalDate.parse(date1), priority1);

            assertEquals(title1, taskManager.getTask(taskID0).getTitle());
            assertEquals(description1, taskManager.getTask(taskID0).getDescription());
            assertEquals(LocalDate.parse(date1), taskManager.getTask(taskID0).getDueDate());
            assertEquals(priority1, taskManager.getTask(taskID0).getPriority());
            assertEquals(1, taskManager.getTasks().size());

        }

        @Test
        @DisplayName("Set Priority Fail")
        public void testSetPriorityFailOnCondition7() {
            String title1 = "task1";
            String description1 = "desc1";
            String date1 = "2024-03-25";
            Priority priority1 = Priority.LOW;
            UUID taskID0 = taskManager.createTask(title1, description1, LocalDate.parse(date1), priority1);
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.setTaskPriority(taskID0, priority);
            });

        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition7() {

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
    @DisplayName("Casos de teste para a condição 8")
    class test8Conditions {

        String title = null;
        String date = null;
        String description = null;
        Priority priority= Priority.HIGH;

        @Test
        @DisplayName("Create Fail")
        public void testCreateFailsOnCondition8() {

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(title, description, LocalDate.parse(date),priority);
            });
        }

        @Test
        @DisplayName("Update Fail")
        public void testUpdateFailOnCondition8() {
            String title1 = "task1";
            String description1 = "desc1";
            String date1 = "2024-03-25";
            Priority priority1 = Priority.LOW;
            UUID taskID0 = taskManager.createTask(title1, description1, LocalDate.parse(date1), priority1);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID0, title, description, LocalDate.parse(date), priority);
            });

        }

        @Test
        @DisplayName("Delete Successful")
        public void testDeleteSuccessfulOnCondition8() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.deleteTask(null);
            });

        }

        @Test
        @DisplayName("Get Fail")
        public void testGetSuccessfulOnCondition8() {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.getTask(null);
            });

        }

        @Test
        @DisplayName("Set Priority Successful")
        public void testSetPriorityFailOnCondition8() {
            String title1 = "task1";
            String description1 = "desc1";
            String date1 = "2024-03-25";
            Priority priority1 = Priority.LOW;

            UUID taskID0 = taskManager.createTask(title1, description1, LocalDate.parse(date1), priority1);
            taskManager.setTaskPriority(taskID0, priority);
            Map<UUID,Task> tasks = taskManager.getTasks();
            assertEquals(priority, tasks.get(taskID0).getPriority());

        }

        @Test
        @DisplayName("List in Order")
        public void testListInOrderOnCondition8() {

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
