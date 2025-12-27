public class Investor extends User {
    private double walletBalance;

    public Investor(String userId, String name, double walletBalance) {
        super(userId, name);
        this.walletBalance = walletBalance;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void deductAmount(double amount) {
        if (amount > walletBalance) {
            throw new IllegalArgumentException("Insufficient wallet balance");
        }
        walletBalance -= amount;
    }
}
