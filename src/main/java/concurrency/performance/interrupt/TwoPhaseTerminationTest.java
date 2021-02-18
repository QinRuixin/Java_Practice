package concurrency.performance.interrupt;

/**
 * @author qin
 * @description todo
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
