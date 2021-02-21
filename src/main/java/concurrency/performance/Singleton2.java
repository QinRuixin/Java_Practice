package concurrency.performance;

/**
 * @author qin
 * @description 单例模式 内部类实现
 * @date 2021-02-21
 */
public class Singleton2 {

    private Singleton2(){}

    private static class LazyHolder{
        static final Singleton2 INSTANCE = new Singleton2();
    }

    //类加载会加锁 没有线程安全问题
    public static Singleton2 getInstance(){
        return LazyHolder.INSTANCE;
    }

}
