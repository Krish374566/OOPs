import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class File {

    // Method that attempts to read a file and throws FileNotFoundException
    public static void readFile(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        Scanner fileScanner = new Scanner(fileReader);

        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }

        fileScanner.close();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = input.nextLine();

        try {
            readFile(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } finally {
            System.out.println("File operation attempted");
        }

        input.close();
    }
}
