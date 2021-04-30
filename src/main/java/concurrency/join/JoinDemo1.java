package concurrency.join;

/**
 * @author qin
 * @description todo
 * @date 2021-02-17
 */
public class JoinDemo1 {
    volatile static int r = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            r = 10;
        });
//        Thread t2 = new Thread()

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("r = "+r);
        System.out.println("end");
    }
}
