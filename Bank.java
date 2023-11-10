public class Bank {
private int balance;

    public void changeBalance(int deltaBalance) {
        this.balance += deltaBalance;
        if (this.balance < 0) {
            this.balance = 0;
        }
    }

    public int getBalance() {
        return this.balance;
    }

    public Bank() {
        this.balance = balance;
    }

}
