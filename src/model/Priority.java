package model;

/**
 * Defines priority levels for task management
 */
public enum Priority {
    HIGH("High", 1),
    MEDIUM("Medium", 2),
    LOW("Low", 3);

    private final String displayName;
    private final int weight;

    Priority(String displayName, int weight) {
        this.displayName = displayName;
        this.weight = weight;
    }

    public String getDisplayName() { return displayName; }
    public int getWeight() { return weight; }
    
    /**
     * Returns priority with higher urgency (lower weight)
     */
    public boolean isMoreUrgentThan(Priority other) {
        return this.weight < other.weight;
    }
}