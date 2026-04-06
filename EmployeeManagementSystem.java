import java.util.*;

// Employee Class
class Employee {
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Display Method
    public void display() {
        System.out.println("---------------------------------");
        System.out.println("Employee ID   : " + id);
        System.out.println("Employee Name : " + name);
        System.out.println("Salary        : " + salary);
    }
}

// Main System Class
public class EmployeeManagementSystem {

    static ArrayList<Employee> employeeList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Employee
    public static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, salary);
        employeeList.add(emp);

        System.out.println("✅ Employee added successfully!");
    }

    // View Employees
    public static void viewEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("⚠ No employees available.");
            return;
        }

        System.out.println("\n===== Employee List =====");
        for (Employee emp : employeeList) {
            emp.display();
        }
    }

    // Update Employee
    public static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {

                System.out.print("Enter new name: ");
                String name = sc.nextLine();

                System.out.print("Enter new salary: ");
                double salary = sc.nextDouble();

                emp.setName(name);
                emp.setSalary(salary);

                System.out.println("✅ Employee updated successfully!");
                return;
            }
        }

        System.out.println("❌ Employee not found.");
    }

    // Delete Employee
    public static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        Iterator<Employee> iterator = employeeList.iterator();

        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getId() == id) {
                iterator.remove();
                System.out.println("✅ Employee deleted successfully!");
                return;
            }
        }

        System.out.println("❌ Employee not found.");
    }

    // Main Method
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n====== Employee Management System ======");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("👋 Exiting program...");
                    break;
                default:
                    System.out.println("⚠ Invalid choice! Try again.");
            }

        } while (choice != 5);
    }
}