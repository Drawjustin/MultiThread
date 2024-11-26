package thread.test;

/*
문제1: Thread 상속
다음 요구사항에 맞게 멀티스레드 프로그램을 작성해라.
1. Thread 클래스를 상속받은 CounterThread 라는 스레드 클래스를 만들자.
2. 이 스레드는 1부터 5까지의 숫자를 1초 간격으로 출력해야 한다. 앞서 우리가 만든 log() 기능을 사용해서 출
력해라.
3. main() 메서드에서 CounterThread 스레드 클래스를 만들고 실행해라.
4. 실행 결과를 참고하자.
 */
public class StartTest1Main {
    public static void main(String[] args) {
        Thread thread1 = new CounterThread();
        thread1.start();
    }
}
