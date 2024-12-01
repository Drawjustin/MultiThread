package thread.util.executor;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class RunnableTask implements Runnable{

    private final String name;
    private int sleepMs = 1000;

    public RunnableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    public RunnableTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        log(name + " 시작");
        sleep(sleepMs); // 작업 시간 시뮬레이션
        log(name + " 완료");
    }
}
