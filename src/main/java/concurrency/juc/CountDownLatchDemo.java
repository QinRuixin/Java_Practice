package concurrency.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author qin
 * @description CountDownLatch demo
 * @date 2021-04-07
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
    }
}
