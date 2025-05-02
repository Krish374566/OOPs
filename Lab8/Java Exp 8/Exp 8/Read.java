import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Read {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("student.txt");

            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: student.txt file not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
