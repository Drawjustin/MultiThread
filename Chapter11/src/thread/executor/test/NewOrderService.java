package thread.executor.test;
import java.util.List;
import java.util.concurrent.*;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class NewOrderService {

    public void order(String orderNo) throws InterruptedException, ExecutionException {

        long stTime = System.currentTimeMillis();

        ExecutorService es = Executors.newFixedThreadPool(3);

        InventoryWorkTask inventoryWorkTask = new InventoryWorkTask(orderNo);
        ShippingWorkTask shippingWorkTask = new ShippingWorkTask(orderNo);
        AccountingWorkTask accountingWorkTask = new AccountingWorkTask(orderNo);

        List<Callable<Boolean>> tasks = List.of(inventoryWorkTask, shippingWorkTask, accountingWorkTask);

        List<Future<Boolean>> futures = es.invokeAll(tasks);

        // 결과 확인
        boolean key = true;
        for (Future<Boolean> future : futures) {
             if(!future.get()){
                key = false;
                break;
            }
        }
        if(key){
            log("모든 주문 처리가 성공적으로 완료되었습니다.");
        }else{
            log("일부 작업이 실패했습니다.");
        }
        long edTime = System.currentTimeMillis();
        log("Task time : " + (edTime-stTime));

        es.close();
    }
    static class InventoryWorkTask implements Callable<Boolean> {

        private final String orderNo;

        public InventoryWorkTask(String orderNo) {
            this.orderNo = orderNo;
        }

        public Boolean call() {
            log("재고 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
    static class ShippingWorkTask implements Callable<Boolean> {
        private final String orderNo;
        public ShippingWorkTask(String orderNo) {
            this.orderNo = orderNo;
        }
        public Boolean call() {
            log("배송 시스템 알림: " + orderNo);
            sleep(1000);
            return true;
        }
    }
    static class AccountingWorkTask implements Callable<Boolean> {
        private final String orderNo;
        public AccountingWorkTask(String orderNo) {
            this.orderNo = orderNo;
        }
        public Boolean call() {
            log("회계 시스템 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
}
