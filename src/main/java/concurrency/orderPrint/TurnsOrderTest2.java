package concurrency.orderPrint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qin
 * @description 多线程交替运行例子  交替打印 A B C  ReentrantLock Condition await signal 实现
 *  * 1. 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串
 *  * 2. 两个线程交替打印 0~100 的奇偶数
 *  * 3. 通过 N 个线程顺序循环打印从 0 至 100
 *  * 4. 多线程按顺序调用，A->B->C，AA 打印 5 次，BB 打印10 次，CC 打印 15 次，重复 10 次
 *  * 5. 用两个线程，一个输出字母，一个输出数字，交替输出 1A2B3C4D...26Z
 * @date 2021-02-20
 */
public class TurnsOrderTest2 {
    public static void main(String[] args) {
        AwaitSignal as = new AwaitSignal(3);
        Condition a = as.newCondition();
        Condition b = as.newCondition();
        Condition c = as.newCondition();

        new Thread(()->{
            as.print("A", a, b);
        }).start();

        new Thread(()->{
            as.print("B", b, c);
        }).start();

        new Thread(()->{
            as.print("C", c, a);
        }).start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        as.lock();
        try{
            System.out.println("begin");
            a.signal();
        } finally {
            as.unlock();
        }

    }
}

class AwaitSignal extends ReentrantLock {
    private int loopNumber;

    public AwaitSignal(int loopNumber){
        this.loopNumber = loopNumber;
    }

    void print(String content, Condition current, Condition next){
        for (int i = 0; i < loopNumber; i++) {
            lock();
            try {
                current.await(); // 会释放锁
                System.out.print(content);
                next.signal();
            }catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unlock();
            }
        }
    }
}
