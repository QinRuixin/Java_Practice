//package thread;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @author qin
// * @date 2020-06-22
// */
//@Slf4j(topic = "demo1")
//public class ThreadDemo {
//    private void demo1() {
//        // 创建线程
//        Thread t1 = new Thread("t1") {
//            @Override
//            public void run() { // 创建任务
//                log.info("running");
//            }
//        };
//        // 启动线程
//        t1.start();
//        log.info("running");
//    }
//
//    private void demo2() {
//        // 创建任务
//        Runnable task2 = new Runnable() {
//            public void run() {
//                log.info("running");
//            }
//        };
//        // 创建线程
//        Thread t2 = new Thread(task2, "t2");
//        // 启动线程
//        t2.start();
//        log.info("running");
//    }
//
//    private void demo3() {
//        Runnable task3 = ()->{log.info("running");};
//        Thread t3 = new Thread(task3, "t3");
//        // Thread t3 = new Thread( ()->{log.info("running");} , "t3");
//        // Thread t3 = new Thread( ()->log.info("running") , "t3");
//        t3.start();
//        log.info("running");
//    }
//
//    public static void main(String[] args) {
//        ThreadDemo threadDemo = new ThreadDemo();
//        threadDemo.demo1();
//        threadDemo.demo2();
//        threadDemo.demo3();
//
//    }
//}
