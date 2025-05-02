import java.util.HashSet;

public class Duplicate {
    public static void main(String[] args) {
        String[] names = {"Aman", "Varchasv", "Sourabh", "Varchasv", "Aman"};
        HashSet<String> uniqueNames = new HashSet<>();

        for (String name : names) {
            uniqueNames.add(name);
        }

        String checkName = "Aman";
        if (uniqueNames.contains(checkName)) {
            System.out.println(checkName + " exists in the set.");
        } else {
            System.out.println(checkName + " does not exist in the set.");
        }

        System.out.println("Unique Names:");
        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}
