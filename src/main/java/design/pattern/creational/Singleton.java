package design.pattern.creational;

/**
 * @author qin
 * @description double check lock singleton
 * @date 2021-06-24
 */
public final class Singleton {

    private static volatile Singleton INSTANCE;

    private Singleton(){}

    public Singleton getInstance(){
        if(INSTANCE != null){
            return INSTANCE;
        }
        synchronized (concurrency.Singleton.class){
            if(INSTANCE != null){
                return INSTANCE;
            }
            INSTANCE = new Singleton();
            return INSTANCE;
        }
    }
}
