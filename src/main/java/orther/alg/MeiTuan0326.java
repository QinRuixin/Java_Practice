package orther.alg;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author qin
 * @description 美团面试题
 * @date 2021-03-26
 */
public class MeiTuan0326 {
    static int calcSum(int[] a, int[] b, int[] c){
        int[] res = new int[3];
        CalcSumRunnable runnable1 = new CalcSumRunnable(a);
        CalcSumRunnable runnable2 = new CalcSumRunnable(b);
        CalcSumRunnable runnable3 = new CalcSumRunnable(c);
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        Thread t3 = new Thread(runnable3);
        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(t1);
        threads.add(t2);
        threads.add(t3);

        for (int i = 0; i < 3; i++) {
            threads.get(i).start();
        }
        for (int i = 0; i < 3; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        res[0] = runnable1.getSum();
        res[1] = runnable2.getSum();
        res[2] = runnable3.getSum();

        return res[0]+res[1]+res[2];
    }

    static Integer threadPoolMethod(int[] a, int[] b, int[] c){
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ArrayList<CalcSumCallable> calcSums = new ArrayList<>();
        CalcSumCallable calcSumCallable1 = new CalcSumCallable(a);
        CalcSumCallable calcSumCallable2 = new CalcSumCallable(b);
        CalcSumCallable calcSumCallable3 = new CalcSumCallable(c);
        Future<Integer> integerFuture1 = executorService.submit(calcSumCallable1);
        Future<Integer> integerFuture2 = executorService.submit(calcSumCallable2);
        Future<Integer> integerFuture3 = executorService.submit(calcSumCallable3);
        Integer res = null;
        try {
             res = integerFuture1.get()+integerFuture2.get()+integerFuture3.get(); //这里会阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        return res;
    }

    public static int countDownLatchMethod(int[] a, int[] b, int[] c){
        CountDownLatch countDownLatch = new CountDownLatch(3);
        CalcSumCountDownLatch cs1 = new CalcSumCountDownLatch(a,countDownLatch);
        CalcSumCountDownLatch cs2 = new CalcSumCountDownLatch(b,countDownLatch);
        CalcSumCountDownLatch cs3 = new CalcSumCountDownLatch(c,countDownLatch);
        Thread t1 = new Thread(cs1);
        Thread t2 = new Thread(cs2);
        Thread t3 = new Thread(cs3);
        t1.run();
        t2.run();
        t3.run();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int res = cs1.getSum() + cs2.getSum() + cs3.getSum();
//        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,5};
        int[] b = {2,3,5};
        int[] c = {1,2,3};

        System.out.println(calcSum(a,b,c));
        System.out.println(threadPoolMethod(a,b,c));
        System.out.println(countDownLatchMethod(a,b,c));
    }
}

class CalcSumCallable implements Callable<Integer> {
// 必须通过 executorService.submit() 方法进行调用
    int[] curList;

    CalcSumCallable(int[] numList){
        curList = numList;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < curList.length; i++) {
            sum += curList[i];
        }
        return sum;
    }
}

class CalcSumRunnable implements Runnable{
    private int sum;
    private int[] curList;

    CalcSumRunnable(int[] numList){
        curList = numList;
    }

    @Override
    public void run(){
        for (int i = 0; i < curList.length; i++) {
            sum += curList[i];
        }
    }

    public int getSum() {
        return sum;
    }
}

class CalcSumCountDownLatch implements Runnable{
    private int sum;
    private int[] curList;
    private CountDownLatch countDownLatch;

    CalcSumCountDownLatch(int[] numList, CountDownLatch c){
        curList = numList;
        countDownLatch = c;
    }

    @Override
    public void run(){
        for (int i = 0; i < curList.length; i++) {
            sum += curList[i];
        }
        countDownLatch.countDown();
    }

    public int getSum() {
        return sum;
    }
}