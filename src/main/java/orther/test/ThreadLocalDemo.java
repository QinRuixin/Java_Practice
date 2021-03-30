package orther.test;

/**
 * @author qin
 * @description ThreadLocal 源码分析
 * @date 2021-03-28
 */
public class ThreadLocalDemo {
    ThreadLocal<Integer> testInt;

    /*
        public T get() {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            ThreadLocalMap.Entry e = map.getEntry(this);
            if (e != null) {
                @SuppressWarnings("unchecked")
                T result = (T)e.value;
                return result;
            }
        }
        return setInitialValue();
    }
    * */

    /*
    ThreadLocalMap getMap(Thread t) {
        return t.threadLocals;
    }
    * */

    /*
    Thread 成员变量  ThreadLocal.ThreadLocalMap threadLocals = null;
    * */

    /*
        static class ThreadLocalMap {
            static class Entry extends WeakReference<ThreadLocal<?>> {
                // The value associated with this ThreadLocal.
                Object value;

                Entry(ThreadLocal<?> k, Object v) {
                    super(k);
                    value = v;
                }
            }
        }
    * */

}
