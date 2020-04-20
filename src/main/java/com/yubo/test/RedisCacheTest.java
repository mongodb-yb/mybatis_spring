package com.yubo.test;

import com.yubo.model.Role;
import com.yubo.service.RoleCacheService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/7 11:26
 */
public class RedisCacheTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        RedisTemplate redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");


        RoleCacheService roleCacheService = applicationContext.getBean(RoleCacheService.class);
        Role role = new Role();
        role.setRoleName("波波威武");
        role.setNote("好好学习，天天up");
//
        roleCacheService.insert(role);
        Role role1 = roleCacheService.getRole(role.getId());
        System.out.println(role1);
//        Role role1 = new Role();
//        role1.setRoleName("波波meimei");
//        role1.setId(44L);
//        roleCacheService.updateRole(role1);
//        System.out.println(roleCacheService.getRole(44L));
//        roleCacheService.clear();
    }
}
