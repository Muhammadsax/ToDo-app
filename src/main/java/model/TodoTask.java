package model;
// lib
import java.time.LocalDateTime;
import java.util.Locale.Category;
import java.util.UUID;

public class TodoTask<Priority>{
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime dueDate;
    private LocalDateTime completedDate;
    private boolean completed;
    private Priority priority;
    private Category category;

    public TodoTask(String title, String description, LocalDateTime dueDate, Priority priority, Category category) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.createdDate = LocalDateTime.now();
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
        this.completed = false;
    }

    public void markAsCompleted() {
        this.completed = true;
        this.completedDate = LocalDateTime.now();
    }

    public void markAsIncomplete() {
        this.completed = false;
        this.completedDate = null;
    }

    // --- Getters and Setters ---

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // --- Overridden Methods ---

    @Override
    public String toString() {
        return "TodoTask{" +
                "title='" + title + '\'' +
                ", completed=" + completed +
                ", priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoTask todoTask = (TodoTask) o;
        return id.equals(todoTask.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}