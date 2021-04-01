package orther.alg;

/**
 * @author qin
 * @description DCL 单例
 * @date 2021-03-28
 */
public class SingletonDemo {

    private volatile static SingletonDemo instance;

    private SingletonDemo(){}

    public static SingletonDemo getInstance(){
        if(instance==null){
            synchronized (SingletonDemo.class){
                if(instance==null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
