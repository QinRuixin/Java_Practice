package JVM.OOMTest;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：-XX:PermSize=6M -XX:MaxPermSize=6M
 * jdk7 之后 Java 字符串常量池移动到了堆
 * 因此用 -Xmx=6M 限制堆的大小来限制
 * @author zzm
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        // 使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        // 6MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}

