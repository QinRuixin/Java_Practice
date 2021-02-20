package concurrency.performance.orderPrint;

import lombok.extern.slf4j.Slf4j;

/**
 * @author qin
 * @description 两个线程顺序执行 wait  notify
 * 也可以用  await  signal
 * @date 2021-02-20
 */

@Slf4j(topic = "c.OrderTest")
public class OrderTest {
    static final Object lock = new Object();
    // 表示 t2 是否运行过
    static boolean t2runned = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (!t2runned) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
            }
        }, "t1");


        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                log.debug("2");
                t2runned = true;
                lock.notify();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
