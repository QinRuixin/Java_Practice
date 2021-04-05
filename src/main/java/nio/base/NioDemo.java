package nio.base;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author qin
 * @description NIO demo
 * @date 2021-04-04
 */
public class NioDemo {
    public static void main(String[] args) throws IOException {

        Buffer bufferNull = null;
        // 文件Channel 非阻塞
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("C:\\Users\\10444\\Desktop\\working_dir\\test.md"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileChannel fileChannel = inputStream.getChannel();
        if(fileChannel!=null){
            int num = fileChannel.read(buffer);
            System.out.println(num);
            fileChannel.close();
        }

// 先清除 否则会 BufferOverflowException
        buffer.clear();
// 写
        buffer.put("随机写入一些内容到 Buffer 中".getBytes());
// Buffer 切换为读模式
        buffer.flip();
        FileChannel fileChannelPut = new RandomAccessFile(new File("C:\\Users\\10444\\Desktop\\working_dir\\test.md"), "rw").getChannel();

        while(buffer.hasRemaining()) {
            // 将 Buffer 中的内容写入文件
            fileChannelPut.write(buffer);
        }
    }
}
