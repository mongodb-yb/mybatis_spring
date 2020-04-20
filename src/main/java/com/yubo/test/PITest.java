package com.yubo.test;

import com.yubo.model.Role;
import com.yubo.service.RoleListService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubo
 * @version V1.0
 * @description 测试隔离级别
 * @date 2020/3/30 13:41
 */
public class PITest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        RoleListService roleListService = applicationContext.getBean(RoleListService.class);
        List<Role> roleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Role role = new Role();
            role.setRoleName("对象_" + (i + 1));
            role.setNote("note_" + (i + 1));
            roleList.add(role);
        }
        int count = roleListService.insertRoleList(roleList);
        System.out.println(count);
    }
}
