package taskManager.src.main;

import java.time.LocalDate;
import java.util.*;

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

    public void deleteTask(UUID taskID) {
        this.tasks.remove(taskID);
    }

    public List<Task> listTasks() {
        List<Task> tasksList = new ArrayList<>(this.tasks.values());
        Comparator<Task> taskComparator = Comparator.comparing(Task::getDueDate).thenComparing(Task::getPriority);
        tasksList.sort(taskComparator);
        return tasksList;
    }

    public void setTaskPriority(UUID taskID, Priority priority) {
        Task task = this.tasks.get(taskID);
        task.setPriority(priority);
        this.tasks.replace(taskID, task);
    }
}
