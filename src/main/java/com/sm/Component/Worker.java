package com.sm.Component;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auth justinniu
 * @Date 2018/8/16
 * @Desc
 */
public class Worker {

    private static final String TASK_QUEUE_NAME = "task_queue";
    private static final String TASK_QUEUE_NAME2 = "task_queue2";
    private static final String EXCHANGE_NAME = "task_exchange";
    private static final String EXCHANGE_NAME2 = "task_exchange2";


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME2, "topic");
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        channel.queueDeclare(TASK_QUEUE_NAME2, true, false, false, null);
        channel.queueBind(TASK_QUEUE_NAME, EXCHANGE_NAME2, "789");
        channel.queueBind(TASK_QUEUE_NAME2, EXCHANGE_NAME2, "zwt.*");
//        channel.queueUnbind(TASK_QUEUE_NAME, EXCHANGE_NAME, "A");
//        channel.queueUnbind(TASK_QUEUE_NAME, EXCHANGE_NAME, "nnnno");
//        channel.queueUnbind(TASK_QUEUE_NAME, EXCHANGE_NAME, "hhhhhh");
//        channel.queueUnbind(TASK_QUEUE_NAME, EXCHANGE_NAME, "B");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        final Consumer consumer1 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println(df.format(new Date()) + " [x] Received '"  + " Consumer1 "+ message + "'");
                try {
                    doWork(message);
                } finally {
                    System.out.println(" [x] Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        final Consumer consumer2 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println(df.format(new Date()) + " [x] Received '" + "Consumer2 " + message + "'");
                try {
                    doWork(message);
                } finally {
                    System.out.println(" [x] Done");
                    if (message.contains("5")) {
                        channel.basicReject(envelope.getDeliveryTag(), true);
                    }
                    else{
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                }
            }
        };
        channel.basicConsume(TASK_QUEUE_NAME2, false, consumer1);
        channel.basicConsume(TASK_QUEUE_NAME, false, consumer2);

    }

    private static void doWork(String task) {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}
