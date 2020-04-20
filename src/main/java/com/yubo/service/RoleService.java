package com.yubo.service;

import com.yubo.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/3/30 11:44
 */
public interface RoleService {

    /**
     * 插入角色信息
     *
     * @param role
     * @return
     */
    int insertRole(Role role);

    /**
     * 批量插入角色信息
     *
     * @param roleList
     * @return
     */
    int insertRoleList(List<Role> roleList);
}
