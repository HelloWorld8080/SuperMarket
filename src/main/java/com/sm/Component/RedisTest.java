package com.sm.Component;

import com.rabbitmq.client.*;
import com.sm.redis.JedisPool;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @Auth justinniu
 * @Date 2018/9/19
 * @Desc
 */
public class RedisTest {
    private static final String EXCHANGE_NAME2 = "task_exchange2";
    private static final String TASK_QUEUE_NAME2 = "task_queue2";
    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Channel getChannel() throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
       return connection.createChannel();

    }

    public void Producer() {
        try {
            Channel channel = getChannel();
            channel.exchangeDeclare(EXCHANGE_NAME2, BuiltinExchangeType.TOPIC);
            Jedis jedis = JedisPool.getJedis();
            String key = "test:20180919:";
            for (int i = 0; i < 10; i++) {
                jedis.set(key + i, i + "");
                channel.basicPublish(EXCHANGE_NAME2, "zwt.123", MessageProperties.PERSISTENT_TEXT_PLAIN, (key + i).getBytes("UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void Consumer() {
        try {
            Channel channel = getChannel();
            channel.exchangeDeclare(EXCHANGE_NAME2, BuiltinExchangeType.TOPIC);
            channel.queueDeclare(TASK_QUEUE_NAME2, true, false, false,null);
            channel.queueBind(TASK_QUEUE_NAME2, EXCHANGE_NAME2, "zwt.*");
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");

                    System.out.println(df.format(new Date()) + " [x] Received '"  + " Consumer1 "+ message + "'");
                    try {
                        System.out.println(JedisPool.getJedis().get(message));
                    } finally {
                        System.out.println(" [x] Done");
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                }
            };
            channel.basicConsume(TASK_QUEUE_NAME2, false, consumer);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws InterruptedException {
        RedisTest redisTest = new RedisTest();
        redisTest.Producer();
        Thread.sleep(1000);
        redisTest.Consumer();
    }

}
