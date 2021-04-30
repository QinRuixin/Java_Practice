package concurrency.interrupt;

/**
 * @author qin
 * @description 两阶段终止 测试
 * @date 2021-02-17
 */
public class TwoPhaseTerminationTest {

    public static void main(String[] args) throws InterruptedException {

        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();

        Thread.sleep(3500);
        tpt.stop();

    }

}
