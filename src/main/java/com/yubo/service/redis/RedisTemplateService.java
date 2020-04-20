package com.yubo.service.redis;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/7 14:05
 */
public interface RedisTemplateService {

    /**
     * 执行Redis多个命令
     */
    void execMultiCommand();

    /**
     * 执行Redis事务
     */
    void execTransaction();

    /**
     * 执行Redis流水线
     */
    void execPipeline();
}
