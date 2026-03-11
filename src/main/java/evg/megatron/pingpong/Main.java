package evg.megatron.pingpong;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    static void main() {
        Object lock = new Object();
        AtomicBoolean isTurnOne = new AtomicBoolean(true);

        Thread threadA = new Thread(
                () -> {
                    while (true) {
                        synchronized (lock) {
                            while (!isTurnOne.get()) {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("1");
                            isTurnOne.set(false);
                            lock.notify();
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }


                }
        );

        Thread threadB = new Thread(
                () -> {
                    while (true) {
                        synchronized (lock) {
                            while (isTurnOne.get()) {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("2");
                            isTurnOne.set(true);
                            lock.notify();
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }


                }
        );

        threadA.start();
        threadB.start();
    }
}