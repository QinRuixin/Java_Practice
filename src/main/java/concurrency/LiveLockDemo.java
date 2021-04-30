package concurrency;

import static java.lang.Thread.sleep;

/**
 * @author qin
 * @description 活锁实例
 * @date 2021-02-20
 */

public class LiveLockDemo {
    static volatile int count = 1000;
    static final Object Lock = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            while (count > 0){
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println("t1 count "+count);
            }
        }).start();

        new Thread(()->{
            while (count <2000){
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println("t2 count "+count);
            }
        }).start();
    }
}
