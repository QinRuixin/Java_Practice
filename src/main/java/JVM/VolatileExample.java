package JVM;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//假设线程A执行writer方法，线程B执行reader方法
class VolatileExample {

    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1;              // 1 线程A修改共享变量
        flag = true;        // 2 线程A写volatile变量
    }

    public void reader() {
        if (flag) {         // 3 线程B读同一个volatile变量
            int i = a;          // 4 线程B读共享变量
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(example::reader);
        executorService.execute(example::writer);
        executorService.execute(example::reader);

        executorService.shutdown();
    }
}
