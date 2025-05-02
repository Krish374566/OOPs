import java.util.ArrayList;
import java.util.HashSet;

public class ArrayList {
    public static void main(String[] args) {
      
        java.util.ArrayList<Integer> numbers = new java.util.ArrayList<>();
    numbers.add(3);
        numbers.add(5);
    numbers.add(3);
        numbers.add(8);
                numbers.add(2);
        numbers.add(5);

        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

       
        int sum = 0;
        for (int num : uniqueNumbers) {
            sum += num;
        }

        System.out.println("Unique values: " + uniqueNumbers);
        System.out.println("Sum of unique values: " + sum);
    }
}
