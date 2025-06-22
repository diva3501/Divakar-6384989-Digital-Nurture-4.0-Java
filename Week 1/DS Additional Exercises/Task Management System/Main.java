public class Main {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();

        tm.addTask(new Task(1, "Design UI", "Pending"));
        tm.addTask(new Task(2, "Setup DB", "Completed"));
        tm.addTask(new Task(3, "API Integration", "In Progress"));

        System.out.println("All Tasks:");
        tm.displayTasks();

        System.out.println("\nSearching Task ID 2:");
        System.out.println(tm.searchTask(2));

        System.out.println("\nDeleting Task ID 2...");
        tm.deleteTask(2);

        System.out.println("\nTasks After Deletion:");
        tm.displayTasks();
    }
}
