import java.util.ArrayList;

public class Prime {
    public static void main(String[] args) {
        
        ArrayList<Integer> numbers = new ArrayList<>();
        
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(10);
        numbers.add(13);
        numbers.add(17);
        
        for (Integer num : numbers) {
           
            int value = num;
           
            if (isPrime(value)) {
                System.out.println(value + " is a prime number.");
            } else {
                System.out.println(value + " is not a prime number.");
            }
        }
    }
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
