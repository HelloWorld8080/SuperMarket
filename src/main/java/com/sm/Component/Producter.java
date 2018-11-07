package com.sm.Component;

import com.rabbitmq.client.*;
import com.sm.redis.JedisPool;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auth justinniu
 * @Date 2018/8/16
 * @Desc
 */
public class Producter {

    private static final String TASK_QUEUE_NAME = "task_queue";
    private static final String TASK_QUEUE_NAME2 = "task_queue2";

    private static final String EXCHANGE_NAME = "task_exchange";
    private static final String EXCHANGE_NAME2 = "task_exchange2";

    private JedisPool jedisPool = new JedisPool();
    public static void main(String[] argv) throws Exception {

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

          //  channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
            channel.exchangeDeclare(EXCHANGE_NAME2, BuiltinExchangeType.TOPIC);

            String[] args = {"Shuai Ge", "ai", "MeiNv", "..."};
            String message = getMessage(args);

            channel.basicPublish(EXCHANGE_NAME2, "zwt" ,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");

            for (int i = 0; i < 50; i++) {
                channel.basicPublish(EXCHANGE_NAME2, "zwt.123",
                        MessageProperties.PERSISTENT_TEXT_PLAIN,
                        (message + i).getBytes("UTF-8"));

                System.out.println("Sent Message:" + message + i);
            }

//            channel.close();
//            connection.close();
        }

        private static String getMessage (String[]strings){
            if (strings.length < 1)
                return "Hello World!";
            return joinStrings(strings, " ");
        }

        private static String joinStrings (String[] strings, String delimiter){
            int length = strings.length;
            if (length == 0) return "";
            StringBuilder words = new StringBuilder(strings[0]);
            for (int i = 1; i < length; i++) {
                words.append(delimiter).append(strings[i]);
            }
            return words.toString();
        }
    }

