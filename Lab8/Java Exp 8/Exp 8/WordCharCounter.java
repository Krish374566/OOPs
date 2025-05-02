import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCharCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the file name: ");
        String fileName = input.nextLine();

        int charCount = 0;
        int wordCount = 0;

        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner fileScanner = new Scanner(fileReader);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                // Count characters (excluding whitespace)
                for (char c : line.toCharArray()) {
                    if (!Character.isWhitespace(c)) {
                        charCount++;
                    }
                }

                // Count words
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            fileScanner.close();
            fileReader.close();

            System.out.println("Total words: " + wordCount);
            System.out.println("Total characters (excluding whitespace): " + charCount);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }

        input.close();
    }
}
