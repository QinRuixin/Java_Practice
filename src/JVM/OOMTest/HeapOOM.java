package JVM.OOMTest;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author zzm
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}

/*
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid11960.hprof ...
Heap dump file created [28250461 bytes in 0.118 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 */
