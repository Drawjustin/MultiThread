package thread.volatile1;


import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class VolatileFageMain {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("runFlage = " + task.runFlag);
        t.start();

        sleep(1000);
        log("runFlage를 false로 변경 시도");
        task.runFlag = false;
        log("runFlage = " + task.runFlag);
        log("main 종료");
    }
    static class MyTask implements Runnable{
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while(runFlag){
                // runFlag가 false로 변하면 탈출

            }
            log("task 종료");
        }
    }
}
