package concurrency.performance.orderPrint;

import java.util.concurrent.locks.LockSupport;

/**
 * @author qin
 * @description 多线程交替运行例子  交替打印 A B C  LockSupport park unpark 实现
 * @date 2021-02-20
 */
public class TurnsOrderTest3 {
    static Thread t1,t2,t3;

    public static void main(String[] args) throws InterruptedException {
        ParkUnpark pu = new ParkUnpark(3);
        t1 = new Thread(()->{
            pu.print("A",t2);
        });
        t2 = new Thread(()->{
            pu.print("B",t3);
        });
        t3 = new Thread(()->{
            pu.print("C",t1);
        });
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1);

        LockSupport.unpark(t1);
    }
}

class ParkUnpark{
    private int loopNumber;

    ParkUnpark(int loopNumber){
        this.loopNumber = loopNumber;
    }

    void print(String content, Thread next){
        for (int i = 0; i < loopNumber; i++) {
            LockSupport.park();
            System.out.print(content);
            LockSupport.unpark(next);
        }
    }
}