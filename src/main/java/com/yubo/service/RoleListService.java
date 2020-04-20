package com.yubo.service;

import com.yubo.model.Role;

import java.util.List;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/3/30 12:00
 */
public interface RoleListService {

    /**
     * 批量插入角色信息
     *
     * @param roleList
     * @return
     */
    int insertRoleList(List<Role> roleList);
}
