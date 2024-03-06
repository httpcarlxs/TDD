package src.main;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TaskManager {
    private final Map<UUID, Task> tasks;

    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    public UUID createTask(String task1, String descTask1, String date, Priority priority) {
        return null;
    }

    public Map<UUID, Task> getTasks() {
        return null;
    }

    public Task getTask(UUID taskID) {
        return null;
    }
}
