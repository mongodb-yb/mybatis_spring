package com.yubo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author yubo
 * @version V1.0
 * @description 测试redis的发布订阅
 * @date 2020/4/3 14:02
 */
public class MessageListenerTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        RedisTemplate redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");
        String channel = "chat";
        // 发布消息
        redisTemplate.convertAndSend(channel, "波神，好好学习，天天向上");
    }
}
