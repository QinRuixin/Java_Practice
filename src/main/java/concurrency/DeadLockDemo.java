package concurrency;

/**
 * @author qin
 * @description 死锁实例
 * jps
 * jstack <process num>
 * @date 2021-02-20
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        new DeadLockDemo().deadLockTest();
    }

    public void deadLockTest(){
        Object ObjA = new Object();
        Object ObjB = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (ObjA) {
                System.out.println("t1 get ObjA");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 wait ObjB");
                synchronized (ObjB) {
                    System.out.println("t1 get ObjB");
                }
            }
        }, "t1");

        Thread thread2 = new Thread(()->{
            synchronized (ObjB){
                System.out.println("t2 get ObjB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 wait ObjA");
                synchronized (ObjA){
                    System.out.println("t2 get ObjA");
                }
            }
        },"t2");

        thread1.start();
        thread2.start();

    }
}
