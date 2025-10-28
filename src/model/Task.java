package model;

import java.time.LocalDate;

/**
 * Represents a task with unique identifier, title, description, 
 * due date, priority level, and completion status.
 */
public class Task {
    private String id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Priority priority;
    private boolean completed;
    private LocalDate createdAt;

    public Task(String id, String title, String description, LocalDate dueDate, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
        this.createdAt = LocalDate.now();
    }

    // Core accessors
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getDueDate() { return dueDate; }
    public Priority getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public LocalDate getCreatedAt() { return createdAt; }

    // State modifiers
    public void markComplete() { this.completed = true; }
    public void markIncomplete() { this.completed = false; }
    
    // Property updaters
    public void updateTitle(String title) { this.title = title; }
    public void updateDescription(String description) { this.description = description; }
    public void updateDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public void updatePriority(Priority priority) { this.priority = priority; }

    /**
     * Checks if task is overdue based on current date
     */
    public boolean isOverdue() {
        return !completed && dueDate.isBefore(LocalDate.now());
    }

    /**
     * Provides formatted string representation for display
     */
    @Override
    public String toString() {
        String status = completed ? "[DONE]" : "[PENDING]";
        String overdue = isOverdue() ? " [OVERDUE]" : "";
        return String.format("[%s] %s | Due: %s | Priority: %s%s", 
                           status, title, dueDate, priority, overdue);
    }
}