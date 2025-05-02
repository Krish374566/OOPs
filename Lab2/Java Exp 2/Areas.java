import java.util.Scanner;

public class Areas {

    // Method for rectangle area
    public static double calculateRectangleArea(double length, double breadth) {
        return length * breadth;
    }

    // Method for square area
    public static double calculateSquareArea(double side) {
        return side * side;
    }

    // Method for circle area
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius; // Using Math.PI for accuracy
    }

    // Method for triangle area
    public static double calculateTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the shape to calculate the area:");
        System.out.println("1. Rectangle");
        System.out.println("2. Square");
        System.out.println("3. Circle");
        System.out.println("4. Triangle");

        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: // Rectangle
                System.out.print("Enter the length of the rectangle: ");
                double length = scanner.nextDouble();
                System.out.print("Enter the breadth of the rectangle: ");
                double breadth = scanner.nextDouble();
                System.out.println("Area of Rectangle: " + calculateRectangleArea(length, breadth));
                break;

            case 2: // Square
                System.out.print("Enter the side of the square: ");
                double side = scanner.nextDouble();
                System.out.println("Area of Square: " + calculateSquareArea(side));
                break;

            case 3: // Circle
                System.out.print("Enter the radius of the circle: ");
                double radius = scanner.nextDouble();
                System.out.println("Area of Circle: " + calculateCircleArea(radius));
                break;

            case 4: // Triangle
                System.out.print("Enter the base of the triangle: ");
                double base = scanner.nextDouble();
                System.out.print("Enter the height of the triangle: ");
                double height = scanner.nextDouble();
                System.out.println("Area of Triangle: " + calculateTriangleArea(base, height));
                break;

            default: 
                System.out.println("Invalid choice! Please enter a number between 1 and 4.");
        }

        scanner.close();
    }
}