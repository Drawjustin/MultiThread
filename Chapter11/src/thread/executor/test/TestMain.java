package thread.executor.test;

import java.util.concurrent.ExecutionException;

public class TestMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        OldOrderService oldOrderService = new OldOrderService();
        oldOrderService.order("1");

        NewOrderService newOrderService = new NewOrderService();
        newOrderService.order("1");


    }
}
