package evg.megatron.deadlock;

public class BankService {

    public static void transfer(BankAccount from, BankAccount to, double amount) {
        synchronized (from.getBalanceLock()) {
            // захватываем монитор счета отправителя
            System.out.println(Thread.currentThread().getName() + " захватил счет " + from.getId());

            // имитируем io запрос с задержкой
            // из-за задержки второй поток успеет стартовать и захватил монитор у счета получателя
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " пытаюсь захватить счет " + to.getId());
            // пытаемся захватить монитор счета получателя, при этом не отпуская монитор счета отправителя
            synchronized (to.getBalanceLock()) {
                System.out.println("Сюда никто и никогда не должен попасть");
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println(Thread.currentThread().getName() + " успешно завершил перевод!");
            }

        }
    }
}
