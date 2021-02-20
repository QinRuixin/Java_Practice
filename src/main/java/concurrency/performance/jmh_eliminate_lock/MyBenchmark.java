package concurrency.performance.jmh_eliminate_lock;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @author qin
 * @description 锁消除测试  打成 jar 包后
 *  java -jar ....jar
 *  java -XX:-EliminateLocks -jar ....jar
 *  对比是否开启锁消除的性能
 * @date 2021-02-18
 */

@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations=3)
@Measurement(iterations=5)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {
    static int x = 0;
    @Benchmark
    public void a() throws Exception {
        x++;
    }
    @Benchmark
    // JIT  即时编译器
    public void b() throws Exception {
        Object o = new Object();
        synchronized (o) {
            x++;
        }
    }
}
