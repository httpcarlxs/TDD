package src.main;

import java.time.LocalDate;
import java.util.UUID;

public class Task {

    private final UUID id;
    private String title;
    private String description;
    private LocalDate date;
    private Priority priority;

    public Task(String title, String description, LocalDate date, Priority priority) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.date = date;
        this.priority = priority;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public Priority getPriority() {
        return this.priority;
    }
}
