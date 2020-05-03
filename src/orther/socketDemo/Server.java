package orther.socketDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qin
 * @date 2020-05-03
 */
public class Server {
    public static void main(String[] args) {
        try {
            // 创建 ServerSocket 监听 8080 窗口
            ServerSocket server = new ServerSocket(8080);
            //等待请求
            Socket socket = server.accept();
            //接收到请求后使用 socket 进行通信，创建 BufferedReader 用于读取数据
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = bufferedReader.readLine();
            System.out.println("received from client: "+ line);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("received data: "+line);
            pw.flush();
            // 关闭资源  有更好的方式？
            pw.close();
            bufferedReader.close();
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
