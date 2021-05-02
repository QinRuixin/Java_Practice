package mq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author qin
 * @description RabbitMQ 消费者
 * @date 2021-05-01
 */
public class Consumer {
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

        // 声明队列
        String queueName = channel.queueDeclare().getQueue();
        String routingKey = "testRoutingKey";
        // 绑定队列，通过路由键 testRoutingKey 将队列和交换器绑定起来
        channel.queueBind(queueName, exchangeName, routingKey);

        while (true){
            // 消费消息
            boolean autoAck = false;

            String consumerTag = "";
            channel.basicConsume(queueName, autoAck, consumerTag, new DefaultConsumer(channel){

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String routingKey = envelope.getRoutingKey();
                    String contentType = properties.getContentType();

                    System.out.println("消费的路由键："+ routingKey);
                    System.out.println("消费的内容类型："+ contentType);
                    long deliveryTag = envelope.getDeliveryTag();
                    // 确认消息
                    channel.basicAck(deliveryTag, false);
                    System.out.println("消费的消息体内容：");
                    String bodyStr = new String(body, "UTF-8");
                    System.out.println(bodyStr);

                }
            });
        }

    }
}
