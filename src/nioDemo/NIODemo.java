package nioDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Map;

public class NIODemo {
    public static void main(String[] args) {
//        System.out.println(args[0]);
        //打印 System.getProperties()
//        Properties p = System.getProperties();
//        p.forEach((k, v) -> System.out.println(k + ":" + v));

        Path path = Paths.get(System.getProperty("user.home"),"Downloads");
//        System.out.printf("toString: %s %n",path.toString());
//        path.forEach(System.out::println);

        try {
            BasicFileAttributes attr = Files.readAttributes(path,BasicFileAttributes.class);
            System.out.println(attr.isDirectory());
            System.out.println(attr.creationTime());
            System.out.println(attr.lastAccessTime());
            System.out.println(attr.lastModifiedTime());
            long curTime = System.currentTimeMillis();
            FileTime ft = FileTime.fromMillis(curTime);
            Files.setAttribute(path, "basic:lastModifiedTime",ft);
            Map<String,Object> attrs = Files.readAttributes(path,"creationTime,lastAccessTime,lastModifiedTime");
            attrs.forEach((k,v)->System.out.println(k+":"+v));

        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println(attr.lastModifiedTime());
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
