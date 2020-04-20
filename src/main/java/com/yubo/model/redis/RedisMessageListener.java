package com.yubo.model.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author yubo
 * @version V1.0
 * @description 接受消息
 * @date 2020/4/3 11:52
 */
public class RedisMessageListener implements MessageListener {

    private RedisTemplate redisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        // 获取消息
        byte[] body = message.getBody();
        // 使用值序列化器转换
        String messageBody = (String) getRedisTemplate().getValueSerializer().deserialize(body);
        System.out.println(messageBody);
        // 获取消息渠道
        byte[] channel = message.getChannel();
        // 使用字符串序列化器进行转换
        String messageChannel = (String) getRedisTemplate().getValueSerializer().deserialize(channel);
        System.err.println(messageChannel);
        // 渠道名称转换
        String bytesStr = new String(bytes);
        System.err.println(bytesStr);
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
