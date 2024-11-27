package control.interrupt.Yeild;

import static thread.util.ThreadUtils.sleep;

public class YeildCustomMain {
    static final int THREAD_COUNT = 100000;
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];

        long start = System.currentTimeMillis();

        // 스레드 생성 및 시작
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new MyRunnable());
            threads[i].start();
        }

        // 모든 스레드가 종료될 때까지 대기
        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                threads[i].join(); // 해당 스레드가 끝날 때까지 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("All threads completed. Time taken: " + (end - start) + "ms");
    }
    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+" - " + i);
                // 1. empty
                // sleep(1); // 2. sleep
                // Thread.yield(); //3. yield

            }
        }
    }
}
