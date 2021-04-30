package concurrency.orderPrint;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @author qin
 * @description 顺序执行
 * LockSupport park and unpark
 * @date 2021-02-20
 */
@Slf4j(topic = "c.OrderTest2")
public class OrderTest2 {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            LockSupport.park();
            log.debug("1");
        }, "t1");
        t1.start();

        new Thread(() -> {
            log.debug("2");
            LockSupport.unpark(t1);
        }, "t2").start();
    }
}
