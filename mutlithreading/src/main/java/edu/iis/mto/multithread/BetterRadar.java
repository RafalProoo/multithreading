package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery battery;

    public BetterRadar(PatriotBattery battery) {
        this.battery = battery;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissile) {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    battery.launchPatriot(enemyMissile);
                }
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}