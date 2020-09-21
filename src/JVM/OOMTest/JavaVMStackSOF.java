package JVM.OOMTest;

/**
 * VM Args：-Xss128k
 * @author zzm
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}

// stack length:18727
// Exception in thread "main" java.lang.StackOverflowError

// 设置 128k 之后
// stack length:981
// Exception in thread "main" java.lang.StackOverflowError