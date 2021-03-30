package JVM.stackOverTest;

/**
 * @author qin
 * @description VM args: -Xss128k -XX:+HeapDumpOnOutOfMemoryError
 * @date 2021-03-30
 */
public class StackOverDemo {

    private int stackDepth = 1;

    public void stackLeak(){
        stackDepth++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackOverDemo stackOverDemo = new StackOverDemo();
        try {
            stackOverDemo.stackLeak();
        }catch (Throwable e){
            System.out.println("stack depth  " + stackOverDemo.stackDepth);
            e.printStackTrace();
        }
        stackOverDemo.stackLeak();
    }

}
