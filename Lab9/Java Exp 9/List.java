import java.util.ArrayList;

public class List {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        // Adding employees
        employees.add(new Employee("Alice", 1, 50000));
        employees.add(new Employee("Bob", 2, 60000));
        employees.add(new Employee("Charlie", 3, 70000));

        // Updating salary of an employee
        for (Employee emp : employees) {
            if (emp.id == 2) {
                emp.salary = 65000;
            }
        }

        // Removing an employee by id
        employees.removeIf(emp -> emp.id == 1);

        // Printing remaining employees
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', id=" + id + ", salary=" + salary + "}";
    }
}