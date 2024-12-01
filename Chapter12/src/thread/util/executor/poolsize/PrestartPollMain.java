package thread.util.executor.poolsize;

import java.util.concurrent.*;

import static thread.util.ThreadUtils.sleep;
import static thread.util.executor.ExecutorUtils.printState;

public class PrestartPollMain {
    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);
        ExecutorService es = new ThreadPoolExecutor(2,100,3000, TimeUnit.SECONDS,workQueue);
        printState(es);
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) es;
        poolExecutor.prestartAllCoreThreads();
        sleep(100);
        printState(es);
        System.out.println("==========================");
        ExecutorService es2 = Executors.newFixedThreadPool(1000);
        printState(es2);
        ThreadPoolExecutor poolExecutor2 = (ThreadPoolExecutor) es2;
        poolExecutor2.prestartAllCoreThreads();
        sleep(100);
        printState(es2);
    }
}
