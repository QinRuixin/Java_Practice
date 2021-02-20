package concurrency.performance.orderPrint;

/**
 * @author qin
 * @description 多线程交替运行例子  交替打印 A B C  wait notify 实现
 * 1. 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串
 * 2. 两个线程交替打印 0~100 的奇偶数
 * 3. 通过 N 个线程顺序循环打印从 0 至 100
 * 4. 多线程按顺序调用，A->B->C，AA 打印 5 次，BB 打印10 次，CC 打印 15 次，重复 10 次
 * 5. 用两个线程，一个输出字母，一个输出数字，交替输出 1A2B3C4D...26Z
 * @date 2021-02-20
 */
public class TurnsOrderTest {

    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify(3,1);
        // 三个线程！！！
        new Thread(()->{
            wn.print("A",1,2);
        }).start();
        new Thread(()->{
            wn.print("B",2,3);
        }).start();
        new Thread(()->{
            wn.print("C",3,1);
        }).start();

    }
}

class WaitNotify{
    private int loopNum;
    private int waitFlag;

    WaitNotify(int loopNum, int waitFlag){
        this.loopNum = loopNum;
        this.waitFlag = waitFlag;
    }
    // A B C 等待标记   1 2 3
    void print(String content, int waitFlag, int nextFlag){

        for (int i = 0; i < loopNum; i++) {
            synchronized (this){
                while (waitFlag !=this.waitFlag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(content);
                this.waitFlag = nextFlag;
                notifyAll();
            }
        }
    }
}