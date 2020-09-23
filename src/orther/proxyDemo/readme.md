# 代理模式

 ——— . . . . . . . .—————     
| User | --使用--> | Interface |  
 ——— . .  . . . . . .—————     
 . . . . . . . . . . . . .  ↗  . . . . . . . . .  ↖  
 .——————    . . . . . . . . . .——————   
| InterfaceImpl |  <--委托-- | InterfaceProxy |   
 .——————   . . . . . . . . . .——————  
 
## Java 动态代理

```java
static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler invocationHandler );
```

使用Proxy类的newProxyInstance方法。这个方法有三个参数：

1. 一个类加载器(class loader)。  
2. 一个Class对象数组，每个元素都是需要实现的接口。  
3. 一个调用处理器

动态代理步骤：

1. 创建被代理的类（委托类、真实类）（RealObject）及其接口（RealObjectInterface）
2. 创建一个实现接口InvocationHandler的类（InvocationHandlerImpl），它必须实现接口的invoke方法
3. 通过Proxy的静态方法newProxyInstance（）， 创建一个代理对象（realObjectProxy），RealObjectInterface realObjectProxy= (RealObjectInterface) Proxy.newProxyInstance(loader,interfaces,handler);
4. 通过代理对象（realObjectProxy）调用 委托类对象（ realObject）的方法

分析代码可以看出 Java 动态代理 的原理：

1. 通过实现 InvocationHandler 接口创建自己的调用处理器；
2. 通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
3. 通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
4. 通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入。

---

demo2 来自《Java核心技术卷Ⅰ》
