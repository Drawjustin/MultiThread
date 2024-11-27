package thread.control;

import static util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {
        // main 스레드
        Thread thread = Thread.currentThread();
        log("mainThread = " + thread);
        log("mainThread.threadId()="+thread.threadId());
        log("mainThread.getName()="+thread.getName());
        log("mainThread.getPriority()="+thread.getPriority());
        log("mainThread.getThreadGroup()="+thread.getThreadGroup());
        log("mainThread.getState()="+thread.getState());

        // myThread 스레드
        Thread myThread = new Thread(() -> {});
        myThread.setName("myThread");
        log("myThread = " + myThread);
        log("myThread.threadId()="+myThread.threadId());
        log("myThread.getName()="+myThread.getName());
        log("myThread.getPriority()="+myThread.getPriority());
        log("myThread.getThreadGroup()="+myThread.getThreadGroup());
        log("myThread.getState()="+myThread.getState());

    }
}
