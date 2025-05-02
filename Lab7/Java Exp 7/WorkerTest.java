abstract class W {
    String name;

    W(String name) {
        this.name = name;
    }

    abstract double computePay();
    abstract void displayInfo();
}

class FT extends W {
    double monthlySalary;

    FT(String name, double salary) {
        super(name);
        this.monthlySalary = salary;
    }

    double computePay() {
        return monthlySalary;
    }

    void displayInfo() {
        System.out.println("Full-Time Worker: " + name + ", Pay: " + computePay());
    }
}

class PT extends W {
    double hourlyRate;
    int hoursWorked;

    PT(String name, double rate, int hours) {
        super(name);
        this.hourlyRate = rate;
        this.hoursWorked = hours;
    }

    double computePay() {
        return hourlyRate * hoursWorked;
    }

    void displayInfo() {
        System.out.println("Part-Time Worker: " + name + ", Pay: " + computePay());
    }
}

public class WorkerTest {
    public static void main(String[] args) {
        W fullTime = new FT("Alice", 5000);
        W partTime = new PT("Bob", 20, 80);

        fullTime.displayInfo();
        partTime.displayInfo();
    }
}
