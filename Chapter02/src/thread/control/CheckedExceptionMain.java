package thread.control;

import util.ThreadUtils;

import static util.ThreadUtils.*;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    //부모 메서드가 예외를 던지지 않으니, 자식도 던질 수 없다.
    static class CheckedRunnable implements Runnable{

        @Override
        public void run() /*throws Exception*/ {
            /*throw new Exception();*/
            sleep(1000);
        }
    }
}
