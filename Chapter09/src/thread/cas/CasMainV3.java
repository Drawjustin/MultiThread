package thread.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class CasMainV3 {
    private static final int THREAD_COUNT = 5;
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println("start value = " + atomicInteger.get());

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                incrementAndGet(atomicInteger);
            }
        };
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT ; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        int result = atomicInteger.get();
        System.out.println(atomicInteger.getClass().getSimpleName()+" resultValue: " +result);
    }
    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;
        do{
            getValue = atomicInteger.get(); // thread1: 0, thread
            sleep(100);
            log("getVALUE : " + getValue);
            //thread2 value ->1
            result = atomicInteger.compareAndSet(getValue,getValue+1);
            log("result : "+ result);
        }while(!result);

        return getValue+1;
    }
}
