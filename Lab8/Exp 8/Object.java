import java.io.*;

// Serializable Person class
class Person implements Serializable {
    private static final long serialVersionUID = 1L; // good practice
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Display method
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Object {
    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("Aman", 25);

        // Serialize the object to person.txt
        try {
            FileOutputStream fileOut = new FileOutputStream("person.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Person object serialized to person.txt");
        } catch (IOException e) {
            System.out.println("Serialization failed: " + e.getMessage());
        }

        // Deserialize the object from person.txt
        try {
            FileInputStream fileIn = new FileInputStream("person.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person deserializedPerson = (Person) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("Deserialized Person:");
            deserializedPerson.display();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization failed: " + e.getMessage());
        }
    }
}
 