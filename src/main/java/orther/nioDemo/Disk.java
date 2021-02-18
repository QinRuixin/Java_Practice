package orther.nioDemo;

import java.io.IOException;
import java.nio.file.*;
import java.text.DecimalFormat;

public class Disk {
    public static void main(String[] args) {
//        String s = "  abc   sdf  dfg ";
        String s = "   ";
        String b = s.trim();
        System.out.println(s);
        System.out.println(b);
        if (args.length == 0) {
            FileSystem fs = FileSystems.getDefault();
            for (FileStore store : fs.getFileStores()) {
                try {
                    print(store);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (String file : args) {

                try {
                    FileStore store = Files.getFileStore(Paths.get(file));
                    print(store);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private static void print(FileStore store) throws IOException {
        long total = store.getTotalSpace();
        long used = total - store.getUnallocatedSpace();
        long usable = store.getUsableSpace();
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        System.out.println(store.toString());
        System.out.printf("total:\t%s\tGB%n", formatter.format(total / 1024 / 1024 / 1024));
        System.out.printf("used:\t%s\tGB%n", formatter.format(used / 1024 / 1024 / 1024));
        System.out.printf("usable:\t%s\tGB%n", formatter.format(usable / 1024 / 1024 / 1024));


    }

}
