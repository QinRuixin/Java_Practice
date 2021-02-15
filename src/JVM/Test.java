package JVM;

public class Test {
    final int a;
    Test(){
        a = 1;
    }
    private void sayHello(){
        System.out.println("Hello world");
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.sayHello();
    }
}
