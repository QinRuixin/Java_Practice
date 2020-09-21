package JVM.OOMTest;

public class RuntimeConstantPoolOOM2 {

    public static void main(String[] args) {
        String str1 = new StringBuilder("中国").append("钓鱼岛").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}

// jdk7 之后 Java 字符串常量池移动到了堆   结果为   true  false    第二个 非首次出现