package evg.megatron.livelock;

public class Main {
    static void main() {
        TiredManAfterWorkAtBus jack = new TiredManAfterWorkAtBus("Jack Sparrow");
        TiredManAfterWorkAtBus barbarossa = new TiredManAfterWorkAtBus("Barbarrosa");

        Thread jackThread = new Thread(() -> {
            while (jack.isWantToSitDown()) {
                System.out.println("Так, Я Джек Воробей и я устал после работы и хочу сесть!");
                System.out.println("Но если Барбаросса хочеть сидеть, придеться ему уступить!");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (barbarossa.isWantToSitDown()) {
                    jack.giveUpOnSeat();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    continue;
                }
                System.out.println("В итоге я (Джек) се равно сел!");
                jack.setWantToSitDown(false);
            }

        });


        Thread barbarossaThread = new Thread(() -> {
            while (barbarossa.isWantToSitDown()) {
                System.out.println("Так, Я Барбаросса и я устал после работы и хочу сесть!");
                System.out.println("Но если Джек хочеть сидеть, придеться ему уступить!");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (jack.isWantToSitDown()) {
                    barbarossa.giveUpOnSeat();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    continue;
                }
                System.out.println("В итоге я (Барбароса) се равно сел!");
                barbarossa.setWantToSitDown(false);
            }
        });

        jackThread.start();
        barbarossaThread.start();
    }
}
