package evg.megatron.deadlock;

public class BankAccount {
    private long id;
    private double balance;
    private final Object balanceLock = new Object();

    public BankAccount(long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (balance - amount < 0) {
            System.out.println("Недостаточно средств");
            return;
        }
        synchronized (balanceLock) {
            if (balance - amount < 0) {
                System.out.println("Недостаточно средств");
                return;
            }
            balance -= amount;
        }
    }

    public void deposit(double amount) {
        synchronized (balanceLock) {
            balance += amount;
        }
    }

    public void showInfo() {
        System.out.println("Account id: " + id);
        System.out.println("Balance: " + balance);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Object getBalanceLock() {
        return balanceLock;
    }
}
