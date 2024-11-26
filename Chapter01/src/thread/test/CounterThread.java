package thread.test;

import static util.MyLogger.log;

public class CounterThread extends Thread {
    @Override
    public void run(){
        try {
            for (int i = 1; i <= 5; i++) {
                log("value:" + i);
                sleep(1000);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
