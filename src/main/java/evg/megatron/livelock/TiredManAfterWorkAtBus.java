package evg.megatron.livelock;

public class TiredManAfterWorkAtBus {
    private volatile boolean isWantToSitDown = true;
    private String name;

    public TiredManAfterWorkAtBus(String name) {
        this.name = name;
    }

    public boolean isWantToSitDown() {
        return isWantToSitDown;
    }

    public void giveUpOnSeat() {
        System.out.println("Пожалуйста, я " + name + " вам уступаю!");
    }

    public String getName() {
        return name;
    }

    public void setWantToSitDown(boolean wantToSitDown) {
        isWantToSitDown = wantToSitDown;
    }
}
