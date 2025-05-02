class SuperClass {
    private int privateNumber = 42;

    public int getPrivateNumber() {
        return privateNumber;
    }
}

class SubClass extends SuperClass {
    public void displayPrivateNumber() {
       
        System.out.println("Private Number (accessed via getter): " + getPrivateNumber());
    }
}

public class MainClass {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.displayPrivateNumber();
    }
}