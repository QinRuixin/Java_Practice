package mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author qin
 * @description RabbitMQ 生产者
 * @date 2021-05-01
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        // 设置 RabbitMQ 地址
        factory.setHost("localhost");
        factory.setVirtualHost("/");
        // 建立到代理服务器的连接
        Connection conn = factory.newConnection();
        // 创建信道
        Channel channel = conn.createChannel();
        // 声明交换机
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, "direct", true);

        String routingKey = "testRoutingKey";
        // 发布消息
        byte[] messageBodyBytes = "quit".getBytes();
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
        // 关闭信道和连接
        channel.close();
        conn.close();
    }
}
