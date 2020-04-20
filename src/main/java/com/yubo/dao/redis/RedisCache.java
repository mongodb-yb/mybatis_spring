package com.yubo.dao.redis;

import org.apache.log4j.Logger;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author yubo
 * @version V1.0
 * @description 自定义缓存实现类
 * 主要用于与数据库交互的过程中所使用的的注解上
 * @date 2020/4/7 9:57
 */
public class RedisCache implements Cache {

    private final Logger log = Logger.getLogger(RedisCache.class);

    private RedisTemplate redisTemplate;

    private String name;

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public Object getNativeCache() {
        return null;
    }

    private static final String KEY_PREFIX_VALUE = "mybatis_spring:";

    @Override
    public ValueWrapper get(Object key) {
        final String keyPrefix = KEY_PREFIX_VALUE + key.toString();
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        Object obj;
        if (keyPrefix.contains("*")) {
            Set<String> keys = redisTemplate.keys(keyPrefix);
            obj = valueOps.multiGet(keys);
        } else {
            obj = valueOps.get(keyPrefix);
        }
        if (obj != null) {
            ValueWrapper valueWrapper = new SimpleValueWrapper(obj);
            return valueWrapper;
        }
        return null;
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }


    @Override
    public void put(Object key, Object value) {
        final String keyPrefix = KEY_PREFIX_VALUE + key.toString();
        if (value != null) {
            try {
                ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
                valueOps.set(keyPrefix, value);
                redisTemplate.expire(keyPrefix, 3, TimeUnit.HOURS);
//                valueOps.set(keyPrefix, value, 3, TimeUnit.HOURS);
            } catch (Throwable throwable) {
                log.error("缓存[" + key + "]失败" + throwable);
            }
        }
    }

    @Override
    public void evict(Object key) {
        final String keyPrefix = KEY_PREFIX_VALUE + key.toString();
        try {
            redisTemplate.delete(redisTemplate.keys(key));
        } catch (Throwable throwable) {
            log.error("删除缓存失败key：[" + key + "]，error：" + throwable);
        }
    }

    @Override
    public void clear() {
    }
}
