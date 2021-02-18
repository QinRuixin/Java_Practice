package orther.proxyDemo;

/**
 * @author qin
 * @date 2020-09-23
 */
public class RealObject implements RealObjectInterface {
    @Override
    public void sayHello() {
        System.out.println("I am RealObject");
    }

    @Override
    public void saySomething(String something) {
        System.out.println(something);
    }
}
