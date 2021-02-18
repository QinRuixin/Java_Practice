package orther.systemDemo;

import java.io.*;

/**
 * @author qin
 * @date 2020-11-26
 */
public class TestDir {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        File file=new File(System.getProperty("user.dir"));
        for(File temp:file.listFiles()){
            if(!temp.isDirectory()){
                System.out.println(temp.toString());
                try {
                    BufferedReader br = new BufferedReader(new FileReader(temp));
                    String str;
                    while ((str = br.readLine()) != null) {
                        System.out.println(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        /*
java.version
Java 运行时环境版本
java.home
Java 安装目录
os.name
操作系统的名称
os.version
操作系统的版本
user.name
用户的账户名称
user.home
用户的主目录
user.dir
         */
    }
}
