 public class Employee {
    private String name;
    private int empid;
    private double salary;

  
    public Employee() {
        this.name = "";
        this.empid = 0;
        this.salary = 0.0;
    }

 
    public Employee(String name, int empid, double salary) {
        this.name = name;
        this.empid = empid;
        this.salary = salary;
    }

    
    public String getName() {
        return name;
    }

    
    public double getSalary() {
        return salary;
    }

    
    public int getEmpid() {
        return empid;
    }

    
    public void increaseSalary(double percentage) {
        if (percentage > 0) {
            salary += salary * percentage / 100;
        }
    }
}

class Manager extends Employee {
    private String department;

 
    public Manager() {
        super();
        this.department = "";
    }

    
    public Manager(String name, int empid, double salary, String department) {
        super(name, empid, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

