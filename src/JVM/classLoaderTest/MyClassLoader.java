package JVM.classLoaderTest;

/**
 * @author qin
 * @description todo
 * @date 2021-01-29
 */
public class MyClassLoader {
    static int j = 0;
    final static String name = "Qin";
    public static void main(String[] args) {
        System.out.println(name);
        int i = 0;
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleep"+ ++i);
            System.out.println(j);
        }
    }

    ClassLoader getClassLoader(){
        ClassLoader cl = this.getClass().getClassLoader();
        return  cl;
    }
}
