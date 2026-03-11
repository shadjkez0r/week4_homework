package evg.megatron.deadlock;

public class Main {
    static void main() {
        BankAccount account1 = new BankAccount(1, 10_000);
        BankAccount account2 = new BankAccount(2, 5_000);

        Thread threadA = new Thread(
                () -> {
                    BankService.transfer(account2, account1, 5_000);
                }
        );

        Thread threadB = new Thread(
                () -> {
                    BankService.transfer(account1, account2, 5_000);
                }
        );

        System.out.println("Стартую поток А...");
        threadA.start();

        System.out.println("Стартую поток Б...");
        threadB.start();

        System.out.println("Жду поток А...");
        try {
            threadA.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Жду поток Б...");
        try {
            threadB.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        account1.showInfo();
        account2.showInfo();
    }
}
