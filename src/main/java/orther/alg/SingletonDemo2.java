package orther.alg;

/**
 * @author qin
 * @description 静态内部类 单例
 * @date 2021-03-28
 */
public class SingletonDemo2 {

    private SingletonDemo2(){}

    private static class SingletonHolder{
        private static final SingletonDemo2 INSTANCE = new SingletonDemo2();
    }

    public static SingletonDemo2 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
