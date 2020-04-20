package com.yubo.service.impl;

import com.yubo.model.Role;
import com.yubo.service.RoleListService;
import com.yubo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/3/30 12:01
 */
@Service
public class RoleListServiceImpl implements RoleListService {

    @Autowired
    private RoleService roleService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public int insertRoleList(List<Role> roleList) {
        int count = 0;
        for (Role role : roleList) {
            count += roleService.insertRole(role);
        }
        return count;
    }
}
