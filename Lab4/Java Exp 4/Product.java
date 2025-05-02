class Product {
    int productId;
    String productName;
    String category;
    private double price;
    static int totalProducts = 0;

    // Default constructor
    Product() {
        this.productId = 0;
        this.productName = "Unknown";
        this.category = "General";
        this.price = 0.0;
        totalProducts++;
    }

    // Parameterized constructor
    Product(int productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        totalProducts++;
    }

    public double getPrice() {
        return price;
    }

    public void displayProductInfo() {
        System.out.println("ID: " + productId);
        System.out.println("Name: " + productName);
        System.out.println("Category: " + category);
        System.out.println("Price: $" + price);
    }

    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    // Method to calculate stock value
    double calculateStockValue(int quantity) {
        return price * quantity;
    }

    // Overloaded method with discount
    double calculateStockValue(int quantity, double discountRate) {
        return (price * quantity) * (1 - discountRate);
    }
}
