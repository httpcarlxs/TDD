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

@DisplayName("Casos de teste para partição de equivalência")
public class EquivalencePartition {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        this.taskManager = new TaskManager();
    }


    @Nested
    @DisplayName("Casos de teste para a função createTask")
    class testCreateEquivalencePartition {

        @Test
        @DisplayName("Todos os atributos válidos - TC1")
        public void testCreateWithAllValidAttributesTask() {
            String title = "task1";
            String date = "2024-03-20";
            String description = "desc1";

            UUID taskID = taskManager.createTask(title, description, LocalDate.parse(date), Priority.HIGH);
            Map<UUID, Task> tasks = taskManager.getTasks();

            assertEquals(1, tasks.size());
            assertEquals(title, taskManager.getTask(taskID).getTitle());
            assertEquals(description, taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse(date), taskManager.getTask(taskID).getDueDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
        }

        @Test
        @DisplayName("title null - TC2")
        void createTaskWithNullTitle() throws Exception {
            String date = "2024-03-20";
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(null, "desc1", LocalDate.parse(date), Priority.LOW);
            });
        }

        @Test
        @DisplayName("Empty title - TC7")
        void createTaskWithEmptyTitle() throws Exception {
            String date = "2024-03-20";
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("", "EOF", LocalDate.parse(date), Priority.LOW);
            });
        }
        @Test
        @DisplayName("Null description - TC3")
        void createTaskWithNullDescription() throws Exception {
            String date = "2024-03-20";
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("task1", null, LocalDate.parse(date), Priority.LOW);
            });
        }

        @Test
        @DisplayName("Empty description - TC8")
        void createTaskWithEmptyDescription() throws Exception {
            String date = "2024-03-20";
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("task1", "", LocalDate.parse(date), Priority.LOW);
            });
        }

        @Test
        @DisplayName("Null date - TC4")
        void createTaskWithNullDate() throws Exception {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("task1", "desc1", null, Priority.LOW);
            });
        }

        @Test
        @DisplayName("Empty date - TC9")
        void createTaskWithEmptyDate() throws Exception {
            String date = "";
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);
            });
        }

        @Test
        @DisplayName("Null priority - TC5")
        void createTaskWithNullPriority() throws Exception {
            String date = "2024-03-20";
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("task1", "desc1", LocalDate.parse(date),null);
            });
        }

        @Test
        @DisplayName("Empty priority - TC10 ")
        void createTaskWithEmptyPriority() throws Exception {
            String date = "2024-03-20";
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.valueOf(""));
            });
        }

        @Test
        @DisplayName("All Null Attributes - TC6")
        void createTaskWithAllAttributesNull() throws Exception {
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask(null, null, null,null);
            });
        }

        @Test
        @DisplayName("All Empty Attributes - TC11")
        void createTaskWithAllAttributesEmpty() throws Exception {
            String date = "";
            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.createTask("", "", LocalDate.parse(date),Priority.valueOf(""));
            });
        }

    }

    @Nested
    @DisplayName("Casos de teste para a função setPriority")
    class testSetPriorityEquivalencePartition {

        @Test
        @DisplayName("All Valid Attributes - TC12")
        public void testChangePriorityAllValidAttributes() {
            String date = "2024-03-20";
            UUID taskID0 = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);
            taskManager.setTaskPriority(taskID0, Priority.MEDIUM);
            Map<UUID,Task> tasks = taskManager.getTasks();
            assertEquals(Priority.MEDIUM, tasks.get(taskID0).getPriority());
        }

        @Test
        @DisplayName("Valid ID and Null Priority - TC13")
        public void testChangePriorityValidIDNullPriority() {
            String date = "2024-03-20";
            assertThrows(IllegalArgumentException .class, () -> {
                UUID taskID0 = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);
                taskManager.setTaskPriority(taskID0, null);
            });
        }

        @Test
        @DisplayName("Valid ID and Empty Priority - TC14")
        public void testChangePriorityValidIDEmptyPriority() {
            String date = "2024-03-20";
            assertThrows(IllegalArgumentException .class, () -> {
                UUID taskID0 = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);
                taskManager.setTaskPriority(taskID0, Priority.valueOf(""));
            });
        }

        @Test
        @DisplayName("Null ID and Valid Priority - TC15")
        public void testChangePriorityNullIDValidPriority() {
            String date = "2024-03-20";
            assertThrows(IllegalArgumentException .class, () -> {
                UUID taskID0 = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);
                taskManager.setTaskPriority(null, Priority.HIGH);
            });
        }

        @Test
        @DisplayName("Empty ID and Valid Priority - TC16")
        public void testChangePriorityEmptyIDValidPriority() {
            String date = "2024-03-20";
            assertThrows(IllegalArgumentException .class, () -> {
                UUID taskID0 = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);
                taskManager.setTaskPriority(UUID.fromString(""), Priority.HIGH);
            });
        }
        @Test
        @DisplayName("NonExistent ID and Valid Priority - TC17")
        public void testChangePriorityIDValidPriorityNull() {
            String date = "2024-03-20";
            assertThrows(IllegalArgumentException .class, () -> {
                UUID x = UUID.randomUUID();
                UUID taskID0 = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);
                taskManager.setTaskPriority(x, Priority.HIGH);
            });
        }
    }

    @Nested
    @DisplayName("Casos de testes para os métodos getTask e deleteTask")
    class testGetTaskAndDeleteTaskEquivalencePartition {

        @Test
        @DisplayName("Valid ID get - TC18")
        public void testGetValidTaskID(){
            String title = "task1";
            String date = "2024-03-20";
            String description = "desc1";

            UUID taskID = taskManager.createTask(title, description, LocalDate.parse(date), Priority.HIGH);

            assertEquals(title, taskManager.getTask(taskID).getTitle());
            assertEquals(description, taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse(date), taskManager.getTask(taskID).getDueDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
            assertEquals(1, taskManager.getTasks().size());
        }

        @Test
        @DisplayName("Valid ID delete - TC18")
        public void testDeleteValidTaskID(){
            String date = "2024-03-20";
            UUID taskID0 = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);

            taskManager.deleteTask(taskID0);
            assertEquals(0, taskManager.getTasks().size());

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.getTask(taskID0);
            });
        }

        @Test
        @DisplayName("Null ID get - TC19")
        public void testGetNullTaskID(){

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.getTask(null);
            });
        }


        @Test
        @DisplayName("Null ID delete - TC19")
        public void testDeleteNullTaskID(){

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.deleteTask(null);
            });
        }

        @Test
        @DisplayName("Empty ID get - TC20")
        public void testGetEmptyTaskID(){

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.getTask(UUID.fromString(""));
            });
        }


        @Test
        @DisplayName("Empty ID delete - TC20")
        public void testDeleteEmptyTaskID(){

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.deleteTask(UUID.fromString(""));
            });
        }


        @Test
        @DisplayName("NonExistent ID get - TC21")
        public void testGetNonExistentTaskID(){
            UUID id = UUID.randomUUID();

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.getTask(id);
            });
        }

        @Test
        @DisplayName("NonExistent ID delete - TC21")
        public void testDeleteNonExistentTaskID(){
            UUID id = UUID.randomUUID();

            assertThrows(IllegalArgumentException.class, () -> {
                taskManager.deleteTask(id);
            });
        }
    }

    @Nested
    @DisplayName("Casos de testes para o método listTasks")
    class testListTasksEquivalencePartition {

        @Test
        @DisplayName("Correct Order - TC-EP-22")
        public void testCorrectOrderListTasks() {

            String date = "2024-03-20";
            String date2 = "2024-03-21";

            UUID taskID0 = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.HIGH);
            UUID taskID1 = taskManager.createTask("task2", "desc2", LocalDate.parse(date2), Priority.HIGH);

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

        @Test
        @DisplayName("Incorrect Order - TC23")
        public void testIncorrectOrderListTasks() {

            String date = "2024-03-20";
            String date2 = "2024-03-21";

            UUID taskID0 = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.HIGH);
            UUID taskID1 = taskManager.createTask("task2", "desc2", LocalDate.parse(date2), Priority.HIGH);

            List<Task> tasks = taskManager.listTasks();
            System.out.println(tasks);
            LocalDate previousDate = LocalDate.MIN;
            Priority previousPriority = null;

            for (Task task : tasks) {
                LocalDate currentDate = task.getDueDate();
                Priority currentPriority = task.getPriority();

                assert currentDate.isEqual(previousDate) || currentDate.isAfter(previousDate) ||
                        (currentDate.equals(previousDate) && currentPriority.compareTo(Objects.requireNonNull(previousPriority)) != 0) :
                        "The order of the list its incorrect.";

                previousDate = currentDate;
                previousPriority = currentPriority;
            }

        }

    }

    @Nested
    @DisplayName("Casos de teste para o método updateTask")
    class testUpdateTasksEquivalencePartition {
        @Test
        @DisplayName("All Valid Attributes - TC26")
        public void testUpdateAllAttributesValidTask() {

            String date = "2024-03-20";
            String date2 = "2024-03-21";

            UUID taskID = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);
            taskManager.updateTask(taskID, "task1 atualizada", "desc2", LocalDate.parse(date2), Priority.HIGH);
            assertEquals("Task 0 Updated", taskManager.getTask(taskID).getTitle());
            assertEquals("EOW", taskManager.getTask(taskID).getDescription());
            assertEquals(LocalDate.parse("2023-08-20"), taskManager.getTask(taskID).getDueDate());
            assertEquals(Priority.HIGH, taskManager.getTask(taskID).getPriority());
        }

        @Test
        @DisplayName("Null Title - TC27")
        public void testUpdateWithNullTitle() {
            String date = "2024-03-20";
            String date2 = "2024-03-21";

            UUID taskID = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID, null, "EOW", LocalDate.parse(date2), Priority.HIGH);
            });
        }
        @Test
        @DisplayName("Null Description - TC28")
        public void testUpdateWithNullDescription() {
            String date = "2024-03-20";
            String date2 = "2024-03-21";
            UUID taskID = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID, "Task 0", null, LocalDate.parse(date2), Priority.HIGH);
            });
        }

        @Test
        @DisplayName("Null DueDate - TC29")
        public void testUpdateWithNullDueDate() {
            String date = "2024-03-20";

            UUID taskID = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID, "task1", "desc1", null, Priority.HIGH);
            });
        }

        @Test
        @DisplayName("Null Priority - TC30")
        public void testUpdateWithNullPriority() {
            String date = "2024-03-20";
            String date2 = "2024-03-21";

            UUID taskID = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID, "task1", "desc2", LocalDate.parse(date2), null);
            });
        }

        @Test
        @DisplayName("Only Valid ID - TC31")
        public void testUpdateOnlyValidID() {
            String date = "2024-03-20";

            UUID taskID = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(taskID, null, null, null, null);
            });
        }

        @Test
        @DisplayName("Only Null ID - TC32")
        public void testUpdateWithOnlyNullID() {
            String date = "2024-03-20";
            String date2 = "2024-03-21";

            UUID taskID = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "task1", "desc2", LocalDate.parse(date2), Priority.MEDIUM);
            });
        }

        @Test
        @DisplayName("Empty ID  - TC33")
        public void testUpdateWithEmptyID() {
            String date = "2024-03-20";
            String date2 = "2024-03-21";

            UUID taskID = taskManager.createTask("task1", "desc1", LocalDate.parse(date), Priority.LOW);

            assertThrows(IllegalArgumentException .class, () -> {
                taskManager.updateTask(null, "task1", "desc2", LocalDate.parse(date2), Priority.MEDIUM);
            });
        }

    }
}