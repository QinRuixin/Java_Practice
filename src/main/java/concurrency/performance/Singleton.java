package concurrency.performance;

/**
 * @author qin
 * @description
 * 单例模式——懒汉式   DCL   内部类
 *
 * @date 2021-02-21
 */
public final class Singleton {

    private static volatile Singleton INSTANCE;

    private Singleton(){}

    public Singleton getInstance(){
        if(INSTANCE != null){
            return INSTANCE;
        }
        synchronized (Singleton.class){
            if(INSTANCE != null){
                return INSTANCE;
            }
            INSTANCE = new Singleton();
            return INSTANCE;
        }
    }
}
