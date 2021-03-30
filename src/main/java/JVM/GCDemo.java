package JVM;

/**
 * @author qin
 * @description Run -> Edit Configuration -> VM Option  -XX:+PrintGCDetails
 * @date 2021-03-25
 */
public class GCDemo {
    private static final int _1MB= 1024*1024;
    public static void main(String[] args) {

        byte[] aaa = new byte[_1MB*100];

    }
}
