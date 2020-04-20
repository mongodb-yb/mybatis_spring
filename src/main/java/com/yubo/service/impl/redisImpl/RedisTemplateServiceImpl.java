package com.yubo.service.impl.redisImpl;

import com.yubo.service.redis.RedisTemplateService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/7 14:09
 */
public class RedisTemplateServiceImpl implements RedisTemplateService {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 使用sessionCallBack接口中实现一个redis连接执行多个命令
     */
    @Override
    public void execMultiCommand() {
        Object obj = redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                ValueOperations ops = redisOperations.opsForValue();
                ops.set("key_1", "value_1", 3, TimeUnit.HOURS);
                Object obj = ops.get("key_1");
                return obj;
            }
        });
    }

    /**
     * 使用sessionCallBack接口实现一个Redis连接中进行多命令的事务执行
     */
    @Override
    public void execTransaction() {
        List list = (List) redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                // 监控
                redisTemplate.watch("key_1");
                // 开启事务
                redisOperations.multi();
                // 将命令放入队列
                redisOperations.boundValueOps("key_1").set("value_1");
                redisOperations.opsForHash().put("yubo_hash", "value_2", "1");
                redisOperations.boundListOps("list").leftPop();
                // 执行命令触发事务，将执行结果返回到集合中
                List list = redisOperations.exec();
                return list;
            }
        });
    }

    /**
     * 执行流水线，将多个命令一次性发给Redis服务器，减少客户端与redis服务器的Tcp连接次数
     */
    @Override
    public void execPipeline() {
        List list = redisTemplate.executePipelined(new SessionCallback() {

            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                // 在流水线下，结果不会立刻返回，而是等全部执行完毕后，再返回结果
                redisOperations.boundValueOps("key_1").set("value_1");
                redisOperations.opsForHash().put("yubo_hash", "hash_key", "hash_value");
                List list = new ArrayList();
                redisOperations.boundListOps(list).leftPop();
                return null;
            }
        });
    }
}
