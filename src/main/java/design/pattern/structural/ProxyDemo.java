package design.pattern.structural;

/**
 * @author qin
 * @description 代理模式
 * @date 2021-04-01
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        RealProxy realProxy = new RealProxy();
        realProxy.setSubject(subject);
        realProxy.doSomething();
    }
}

class Client2{
    ProxyInterface proxyInterface;

    public void setProxyInterface(ProxyInterface proxyInterface) {
        this.proxyInterface = proxyInterface;
    }
}

interface ProxyInterface {
    public void doSomething();
}

class Subject implements ProxyInterface {

    @Override
    public void doSomething() {
        System.out.println("Subject do something");
    }
}

class RealProxy implements ProxyInterface {
    Subject subject;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void doSomething() {
        System.out.println("Real Proxy do something");
        subject.doSomething();
    }
}