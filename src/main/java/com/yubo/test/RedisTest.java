package com.yubo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/1 9:44
 */
public class RedisTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        RedisTemplate redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");

        Jedis jedis = new Jedis("localhost", 6379);
        Pipeline pipeline = jedis.pipelined();
        long start = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        for (int i = 0; i < 100000; i++) {
            int j = i + 1;
            pipeline.set("pipelin_key_" + j, "pipelin_value_" + j);
            System.out.println(pipeline.get("pipelin_key_" + j));
        }
        // 只执行命令，不返回结果
//        pipeline.sync();
        // 执行命令，并返回命令返回的结果list
        List list = pipeline.syncAndReturnAll();
        System.out.println(list.size());
        long end = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println("耗时：" + (end - start));


        SessionCallback sessionCallback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                for (int i = 0; i < 100000; i++) {
                    int j = i + 1;
                    pipeline.set("pipelin_key_" + j, "pipelin_value_" + j);
                    System.out.println(pipeline.get("pipelin_key_" + j));
                }
                return null;
            }
        };
        redisTemplate.executePipelined(sessionCallback);
    }

}
