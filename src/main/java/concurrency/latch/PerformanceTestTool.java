package concurrency.latch;

import java.util.concurrent.CountDownLatch;

/**
 * @author qin
 * @description PerformanceTestTool using CountDownLatch
 * @date 2021-02-17
 */
public class PerformanceTestTool {

    public static void main(String[] args) {
        PerformanceTestTool ptt = new PerformanceTestTool();
        try {
            System.out.println(ptt.timecost(10,()->{
                System.out.println(1);
            }));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long timecost(final int times, final Runnable task) throws InterruptedException {
        if (times <= 0) throw new IllegalArgumentException();
        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch overLatch = new CountDownLatch(times);
        for (int i = 0; i < times; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        startLatch.await();
                        //
                        task.run();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    } finally {
                        overLatch.countDown();
                    }
                }
            }).start();
        }
        //
        long start = System.nanoTime();
        startLatch.countDown();
        overLatch.await();
        return System.nanoTime() - start;
    }
}