# NIO

## Buffer

### allocate() 和 allocateDirect() 区别

```java
    public static ByteBuffer allocate(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException();
        return new HeapByteBuffer(capacity, capacity);
    }
```

```java
    public static ByteBuffer allocateDirect(int capacity) {
        return new DirectByteBuffer(capacity);
    }
```

allocate()产生的是HeapByteBuffer的实例, 本质上是一个no direct buffer, allocateDirect()产生的是DirectByteBuffer的实例, 本质是一个direct buffer

主要区别
buffer的创建方式不同, no direct buffer还可以通过封装已存在的byte array来产生
执行IO操作时不同, no direct buffer会将自己复制到中间buffer中, 而direct buffer不会
no direct buffer分配在heap上, 而direct buffer分配在直接内存中, 并不在JVM虚拟机

