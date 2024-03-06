package src.test;

import static org.junit.Assert.*;
import org.junit.Test;
import src.main.Priority;
import src.main.Task;

import java.time.LocalDate;

public class TestTask {

    @Test
    public void testCreateTask() {
        Task task = new Task("task1", "desc task1", LocalDate.parse("2024-03-05"), Priority.HIGH);

        assertEquals("task1", task.getTitle());
        assertEquals("desc task1", task.getDescription());
        assertEquals(LocalDate.parse("2024-03-05"), task.getDate());
        assertEquals(Priority.HIGH, task.getPriority());
    }

    @Test
    public void testSetTitle(){
        Task task = new Task("task1", "desc task1", LocalDate.parse("2024-03-05"), Priority.HIGH);

        String title = task.getTitle();
        String newTitle = "task1 atualizada";

        task.setTitle(newTitle);

        assertNotEquals(title, task.getTitle());
        assertEquals(newTitle, task.getTitle());
    }

    @Test
    public void testSetDescription(){
        Task task = new Task("task1", "desc task1", LocalDate.parse("2024-03-05"), Priority.HIGH);

        String description = task.getDescription();
        String newDescription = "desc atualizada";

        task.setDescription(newDescription);

        assertNotEquals(description, task.getDescription());
        assertEquals(newDescription, task.getDescription());
    }


}
