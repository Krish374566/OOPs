class Customer {
    private double balance;

    public void addBalance(double amount) {
        balance += amount;
    }

    public void addBalance(int amount) {
        balance += amount;
    }

    protected void deductBalance(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }
}
