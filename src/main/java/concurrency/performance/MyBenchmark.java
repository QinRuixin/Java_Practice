package concurrency.performance;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.concurrent.FutureTask;

/**
 * @author qin
 * @date 2020-06-22
 */


@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class MyBenchmark {
    private final static int ONE_HUNDRED_MIL = 100000000;
    static int[] ARRAY = new int[ONE_HUNDRED_MIL];

    static {
        Arrays.fill(ARRAY, 1);
    }
    @Benchmark
    public int b() throws Exception {
        int[] array = ARRAY;
        FutureTask<Integer> t1 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL / 8; i++) {
                        sum += array[0 + i];
                    }
                    return sum;
                }
        );
        FutureTask<Integer> t2 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL / 8; i++) {
                        sum += array[ONE_HUNDRED_MIL / 8 + i];
                    }
                    return sum;
                }
        );
        FutureTask<Integer> t3 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL / 8; i++) {
                        sum += array[ONE_HUNDRED_MIL /8 * 2 + i];
                    }
                    return sum;
                }
        );
        FutureTask<Integer> t4 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL /8; i++) {
                        sum += array[ONE_HUNDRED_MIL /8 * 3 + i];
                    }
                    return sum;
                }
        );
        FutureTask<Integer> t5 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL /8; i++) {
                        sum += array[ONE_HUNDRED_MIL /8 * 4 + i];
                    }
                    return sum;
                }
        );
        FutureTask<Integer> t6 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL /8; i++) {
                        sum += array[ONE_HUNDRED_MIL /8 * 5 + i];
                    }
                    return sum;
                }
        );
        FutureTask<Integer> t7 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL /8; i++) {
                        sum += array[ONE_HUNDRED_MIL /8 * 6 + i];
                    }
                    return sum;
                }
        );
        FutureTask<Integer> t8 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL /8; i++) {
                        sum += array[ONE_HUNDRED_MIL /8 * 7 + i];
                    }
                    return sum;
                }
        );
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();
        return t1.get() + t2.get() + t3.get() + t4.get();

    }
    @Benchmark
    public int c() throws Exception {
        int[] array = ARRAY;
        FutureTask<Integer> t1 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL / 4; i++) {
                        sum += array[0 + i];
                    }
                    return sum;
                }
        );
        FutureTask<Integer> t2 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL / 4; i++) {
                        sum += array[ONE_HUNDRED_MIL / 4 + i];
                    }
                    return sum;
                }
        );
        FutureTask<Integer> t3 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL / 4; i++) {
                        sum += array[ONE_HUNDRED_MIL / 4 * 2 + i];
                    }
                    return sum;
                }
        );
        FutureTask<Integer> t4 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL / 4; i++) {
                        sum += array[ONE_HUNDRED_MIL / 4 * 3 + i];
                    }
                    return sum;
                }
        );
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();
        return t1.get() + t2.get() + t3.get() + t4.get();

    }
    @Benchmark
    public int d() throws Exception {
        final int[] array = ARRAY;
        FutureTask<Integer> t1 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL/2; i++) {
                        sum += array[0 + i];
                    }
                    return sum;
                }
        );
        FutureTask<Integer> t2 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL/2; i++) {
                        sum += array[ONE_HUNDRED_MIL/2 + i];
                    }
                    return sum;
                }
        );
        new Thread(t1).start();
        new Thread(t2).start();
        return t1.get()+t2.get();
    }

    @Benchmark
    public int e() throws Exception {
        final int[] array = ARRAY;
        FutureTask<Integer> t1 = new FutureTask<Integer>(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < ONE_HUNDRED_MIL; i++) {
                        sum += array[0 + i];
                    }
                    return sum;
                }
        );
        new Thread(t1).start();
        return t1.get();
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(MyBenchmark.class.getSimpleName()).build();
        new Runner(options).run();
    }
}

/*

Benchmark            Mode  Samples  Score  Score error  Units
o.s.MyBenchmark.b    avgt        5  0.013        0.001   s/op
o.s.MyBenchmark.c    avgt        5  0.029        0.003   s/op
o.s.MyBenchmark.d    avgt        5  0.027        0.002   s/op
o.s.MyBenchmark.e    avgt        5  0.036        0.002   s/op

 */
