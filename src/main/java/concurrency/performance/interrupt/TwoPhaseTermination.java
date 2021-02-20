package concurrency.performance.interrupt;

/**
 * @author qin
 * @description 两阶段终止模式
 * @date 2021-02-17
 */

public class TwoPhaseTermination {
    private Thread monitor;

    public void start(){
        monitor = new Thread(()->{
            while (true){
                Thread current = Thread.currentThread();
                if(current.isInterrupted()){
//                    log.debug
                    System.out.println("中断返回前处理");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    System.out.println("执行监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    current.interrupt();
                }
            }
        });

        monitor.start();
    }

    public void stop(){
        monitor.interrupt();
    }
}
