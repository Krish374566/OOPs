abstract class Vehicle {
    private String make;
    private String model;

    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public abstract void startEngine();
    public abstract void stopEngine();

    public void serviceInfo() {
        System.out.println("Basic servicing instructions for " + make + " " + model + ":");
        System.out.println("1. Check engine oil.");
        System.out.println("2. Check tire pressure.");
        System.out.println("3. Check brake fluid.");
    }
}

class Car extends Vehicle {

    public Car(String make, String model) {
        super(make, model);
    }

    @Override
    public void startEngine() {
        System.out.println("Starting the car engine...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping the car engine...");
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Corolla");
        myCar.startEngine();
        myCar.serviceInfo();
        myCar.stopEngine();
    }
}
