package com.yubo.controller;

import com.yubo.model.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/9 15:22
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/role", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public Role getRole() {
        Role role = new Role();
        role.setId(9L);
        role.setRoleName("波波大哥");
        return role;
    }
}
