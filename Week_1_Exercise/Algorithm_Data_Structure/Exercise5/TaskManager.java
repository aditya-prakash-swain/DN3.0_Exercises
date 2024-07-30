package Exercise5;

public class TaskManager {
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskManager() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTaskById(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null; 
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTaskById(String taskId) {
        if (head == null) return;

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next; 
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }
    
    
    
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task("T001", "Design Homepage", "In Progress"));
        manager.addTask(new Task("T002", "Develop Backend", "Not Started"));
        manager.addTask(new Task("T003", "Write Documentation", "Completed"));

        System.out.println("All Tasks:");
        manager.traverseTasks();

        System.out.println("\nSearching for task with ID T002:");
        Task task = manager.searchTaskById("T002");
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting task with ID T001.");
        manager.deleteTaskById("T001");

        System.out.println("\nAll Tasks after deletion:");
        manager.traverseTasks();

        System.out.println("\nSearching for deleted task with ID T001:");
        task = manager.searchTaskById("T001");
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found.");
        }
    }
}

