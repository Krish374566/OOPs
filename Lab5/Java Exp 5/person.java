
public class person {
    protected String name;
    protected int age;
    protected String address;

    public person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}

// Staff class extending Person
class Staff extends person {
    protected String staffId;
    protected String department;

    public Staff(String name, int age, String address, String staffId, String department) {
        super(name, age, address);
        this.staffId = staffId;
        this.department = department;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Staff ID: " + staffId);
        System.out.println("Department: " + department);
    }
}

// Professor class extending Staff
class Professor extends Staff {
    private String specialization;

    public Professor(String name, int age, String address, String staffId, String department, String specialization) {
        super(name, age, address, staffId, department);
        this.specialization = specialization;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
    }

    public void conductLecture() {
        System.out.println(name + " is conducting a lecture on " + specialization);
    }
}

// Student class extending Person
class Student extends person {
    protected String studentId;
    protected String course;

    public Student(String name, int age, String address, String studentId, String course) {
        super(name, age, address);
        this.studentId = studentId;
        this.course = course;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }
}

// GraduateStudent class extending Student
class GraduateStudent extends Student {
    private String researchTopic;

    public GraduateStudent(String name, int age, String address, String studentId, String course, String researchTopic) {
        super(name, age, address, studentId, course);
        this.researchTopic = researchTopic;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Research Topic: " + researchTopic);
    }

    public void submitThesis() {
        System.out.println(name + " has submitted a thesis on " + researchTopic);
    }
}

// Main class to demonstrate polymorphism
class Main {
    public static void main(String[] args) {
        person[] people = new person[2];

        people[0] = new Professor("Dr. Smith", 45, "123 University St", "P123", "Computer Science", "Artificial Intelligence");
        people[1] = new GraduateStudent("Alice", 28, "456 College Ave", "S456", "Computer Science", "Machine Learning");

        for (person person : people) {
            person.displayInfo();
            System.out.println();

            if (person instanceof Professor) {
                ((Professor) person).conductLecture();
            } else if (person instanceof GraduateStudent) {
                ((GraduateStudent) person).submitThesis();
            }

            System.out.println();
        }
    }
}
