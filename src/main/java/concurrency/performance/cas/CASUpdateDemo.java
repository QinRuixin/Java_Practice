package concurrency.performance.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

/**
 * @author qin
 * @description 乐观锁 cas 操作
 * @date 2021-02-21
 */
public class CASUpdateDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        updateAndGet(atomicInteger, p->p/2);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.updateAndGet(p->p/2));
        /*
class AtomicInteger 中的方法：
        public final int updateAndGet(IntUnaryOperator updateFunction) {
            int prev, next;
            do {
                prev = get();
                next = updateFunction.applyAsInt(prev);
            } while (!compareAndSet(prev, next));
            return next;
        }

         */
    }

    public static void updateAndGet(AtomicInteger atomicInteger, IntUnaryOperator op){

        while (true){
            int prev = atomicInteger.get();
            int next = op.applyAsInt(prev);
            if(atomicInteger.compareAndSet(prev, next)){
                break;
            }
        }

    }
}
