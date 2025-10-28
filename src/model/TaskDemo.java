package model;

import java.time.LocalDate;

/**
 * Demonstration class with dynamic dates based on current system date
 */
public class TaskDemo {
    
    public static void demonstrateTaskFeatures() {
        System.out.println("=== Task Management Demo - Dynamic Dates ===\n");
        
        // استخدام التاريخ الحالي كمرجع
        LocalDate today = LocalDate.now();
        System.out.println("Current Date: " + today + "\n");
        
        // إنشاء مهام بتواريخ واقعية مرتبطة باليوم الحالي
        Task overdueTask = new Task(
            "TASK-001", 
            "Fix Critical Security Issue", 
            "Resolve authentication vulnerability in login system", 
            today.minusDays(3),  // 📅 متأخرة 3 أيام
            Priority.HIGH
        );
        
        Task dueTodayTask = new Task(
            "TASK-002", 
            "Project Planning Session", 
            "Quarterly roadmap discussion with team leads", 
            today,  // 📅 مستحقة اليوم
            Priority.MEDIUM
        );
        
        Task upcomingTask = new Task(
            "TASK-003", 
            "Update API Documentation", 
            "Add new endpoint examples to developer guide", 
            today.plusDays(5),  // 📅 خلال 5 أيام
            Priority.LOW
        );
        
        Task futureTask = new Task(
            "TASK-004", 
            "Quarterly Review Meeting", 
            "Performance evaluation and planning session", 
            today.plusDays(14),  // 📅 بعد أسبوعين
            Priority.MEDIUM
        );

        // عرض الحالات المختلفة
        System.out.println("1. Task States with Realistic Dates:");
        displayTaskInfo(overdueTask);
        displayTaskInfo(dueTodayTask);
        displayTaskInfo(upcomingTask);
        displayTaskInfo(futureTask);
        
        // عرض سيناريوهات الإكمال
        System.out.println("\n2. Completing Overdue Task:");
        overdueTask.markComplete();
        displayTaskInfo(overdueTask);
        
        // تحليل الأولويات
        System.out.println("\n3. Priority Analysis:");
        comparePriorities(Priority.HIGH, Priority.MEDIUM);
        comparePriorities(Priority.LOW, Priority.HIGH);
        
        // عرض المهام المتأخرة فقط
        System.out.println("\n4. Overdue Status Summary:");
        checkOverdueStatus(overdueTask);
        checkOverdueStatus(dueTodayTask);
        checkOverdueStatus(upcomingTask);
        
        // معلومات إضافية عن التواريخ
        System.out.println("\n5. Date Information:");
        displayDateInfo(overdueTask, "Overdue Task");
        displayDateInfo(dueTodayTask, "Due Today Task");
        displayDateInfo(upcomingTask, "Upcoming Task");
    }
    
    private static void displayTaskInfo(Task task) {
        String status = task.isCompleted() ? "[DONE]" : "[PENDING]";
        String overdue = task.isOverdue() ? " [OVERDUE]" : "";
        System.out.printf("• %s %s | Due: %s | Priority: %s%s\n",
            status, task.getTitle(), task.getDueDate(), 
            task.getPriority().getDisplayName(), overdue);
    }
    
    private static void comparePriorities(Priority p1, Priority p2) {
        System.out.printf("  %s vs %s: %s is more urgent? %s\n",
            p1.getDisplayName(), p2.getDisplayName(),
            p1.getDisplayName(), p1.isMoreUrgentThan(p2));
    }
    
    private static void checkOverdueStatus(Task task) {
        String status = task.isOverdue() ? "OVERDUE" : "On Time";
        System.out.printf("  %s - %s\n", task.getTitle(), status);
    }
    
    private static void displayDateInfo(Task task, String label) {
        long daysUntilDue = java.time.temporal.ChronoUnit.DAYS.between(
            LocalDate.now(), task.getDueDate());
        
        String timing;
        if (daysUntilDue < 0) {
            timing = Math.abs(daysUntilDue) + " days overdue";
        } else if (daysUntilDue == 0) {
            timing = "Due today";
        } else {
            timing = "Due in " + daysUntilDue + " days";
        }
        
        System.out.printf("  %s: %s (%s)\n", label, task.getTitle(), timing);
    }
    
    public static void main(String[] args) {
        demonstrateTaskFeatures();
    }
}