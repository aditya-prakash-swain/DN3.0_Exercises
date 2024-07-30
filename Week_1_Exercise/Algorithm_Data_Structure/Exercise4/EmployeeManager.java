package Exercise4;

public class EmployeeManager {
    private Employee[] employees;
    private int size;
    
    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployeeById(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null; 
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployeeById(String employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete != -1) {
            for (int i = indexToDelete; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[--size] = null; 
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }
    
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee("E001", "John Doe", "Software Engineer", 75000));
        manager.addEmployee(new Employee("E002", "Jane Smith", "Project Manager", 85000));
        manager.addEmployee(new Employee("E003", "Emily Johnson", "QA Analyst", 65000));
        manager.addEmployee(new Employee("E004", "Michael Brown", "UX Designer", 70000));

        System.out.println("All Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching for employee with ID E002:");
        Employee employee = manager.searchEmployeeById("E002");
        if (employee != null) {
            System.out.println("Found: " + employee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting employee with ID E003:");
        manager.deleteEmployeeById("E003");

        System.out.println("\nAll Employees after deletion:");
        manager.traverseEmployees();

        System.out.println("\nSearching for deleted employee with ID E003:");
        employee = manager.searchEmployeeById("E003");
        if (employee != null) {
            System.out.println("Found: " + employee);
        } else {
            System.out.println("Employee not found.");
        }
    }
}
