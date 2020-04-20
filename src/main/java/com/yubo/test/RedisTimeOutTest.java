package com.yubo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author yubo
 * @version V1.0
 * @description redis超时指令测试
 * @date 2020/4/3 14:48
 */
public class RedisTimeOutTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        RedisTemplate redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");
        redisTemplate.execute(new SessionCallback() {
        @Override
        public Object execute(RedisOperations ops) throws DataAccessException {
            ops.boundValueOps("key_1").set("value_1");
            String value1 = (String) ops.boundValueOps("key_1").get();
            // 获取key_1的超时时间
            long expSecond = ops.getExpire("key_1");
            boolean b = false;
            // 设置超时时间
            b = ops.expire("key_1", 120, TimeUnit.SECONDS);
            // 移除超时时间
            b = ops.persist("key_1");
            long l = 0L;
            l = ops.getExpire("key_1");
            // 设置过期时间点
            Long now = System.currentTimeMillis();
            Date date = new Date();
            date.setTime(now + 120000);
            ops.expireAt("key_1", date);
            return null;
        }
    });
}
}
