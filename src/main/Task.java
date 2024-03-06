package src.main;

import java.time.LocalDate;
import java.util.UUID;

public class Task {

    private final UUID id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Priority priority;

    public Task(String title, String description, LocalDate dueDate, Priority priority) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getDuoDate() {
        return this.dueDate;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setDuoDate(LocalDate newDuoDate) {
        this.dueDate = newDuoDate;
    }

    public void setPriority(Priority newPriority) {
        this.priority = newPriority;
    }

    public LocalDate getDate() {
        return null;
    }
}
