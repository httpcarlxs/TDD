package src.main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TaskManager {
    private final Map<UUID, Task> tasks;

    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    public UUID createTask(String title, String description, LocalDate duoDate, Priority priority) {
        Task task = new Task(title, description, duoDate, priority);
        UUID taskID = task.getId();
        tasks.put(taskID, task);
        return taskID;
    }

    public Map<UUID, Task> getTasks() {
        return this.tasks;
    }

    public Task getTask(UUID taskID) {
        return this.tasks.get(taskID);
    }

    public void updateTask(UUID taskID, String title, String description, LocalDate duoDate, Priority priority) {
        Task task = this.tasks.get(taskID);
        task.setTitle(title);
        task.setDescription(description);
        task.setDuoDate(duoDate);
        task.setPriority(priority);
    }
}
