package com.yubo.dao.mapper;

import com.yubo.model.Role;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/3/30 11:45
 */
public interface RoleMapper {
    /**
     * 插入角色信息
     *
     * @param role
     */
    int insertRole(Role role);
}
