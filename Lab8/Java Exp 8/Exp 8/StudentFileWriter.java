import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentFileWriter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter student's name: ");
        String name = input.nextLine();

        System.out.print("Enter roll number: ");
        String rollNumber = input.nextLine();

        System.out.print("Enter grade: ");
        String grade = input.nextLine();

        // Writing to file using FileWriter in append mode
        try {
            FileWriter writer = new FileWriter("student.txt", true); // 'true' for append mode
            writer.write("Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade + "\n");
            writer.close();
            System.out.println("Student information saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        input.close();
    }
}
