package orther.proxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author qin
 * @date 2020-09-23
 */
public class ProxyTest {
    public static void main(String[] args) {
        RealObjectInterface realObject = new RealObject();  // 要被代理的对象
        InvocationHandler handler = new InvocationHandlerImpl(realObject);  // 触发方法
        RealObjectInterface proxyInstance = (RealObjectInterface)Proxy.newProxyInstance(RealObjectInterface.class.getClassLoader(), new Class[]{RealObjectInterface.class}, handler);

        proxyInstance.sayHello();
        proxyInstance.saySomething("java proxy");
    }
}
/*
I am InvocationHandlerImpl
I am RealObject
I am InvocationHandlerImpl
java proxy
 */