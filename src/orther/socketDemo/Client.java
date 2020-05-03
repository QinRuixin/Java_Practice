package orther.socketDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author qin
 * @date 2020-05-03
 */
public class Client {
    public static void main(String[] args) {
        String msg = "Client Data";

        try{
            // 创建一个 Socket， 跟本机的 8080 端口连接
            Socket  socket = new Socket("127.0.0.1",8080);
            // 使用 Socket创建 PrintWriter 和 PrintReader 进行读写数据
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 发送数据
            pw.println(msg);
            pw.flush();
            // 接收数据
            String line = bufferedReader.readLine();
            System.out.println("received from server: " + line);
            // 关闭资源
            pw.close();
            bufferedReader.close();
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
