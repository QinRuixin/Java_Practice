package orther.proxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author qin
 * @date 2020-09-23
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Object realObject;

    InvocationHandlerImpl(Object realObject){
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("I am InvocationHandlerImpl");
        return method.invoke(realObject,args);
    }
}
