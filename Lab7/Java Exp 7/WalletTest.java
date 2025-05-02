interface Wlt {
    void addFunds(double amount);
    void spendFunds(double amount);
}

class DW implements Wlt {
    private double balance = 0;

    public void addFunds(double amount) {
        if (amount > 0) balance += amount;
    }

    public void spendFunds(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class WalletTest {
    public static void main(String[] args) {
        DW myWallet = new DW();

        myWallet.addFunds(100);
        myWallet.spendFunds(40);
        myWallet.addFunds(60);
        myWallet.spendFunds(30);

        System.out.println("Final Balance: $" + myWallet.getBalance());
    }
}
