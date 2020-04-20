package com.yubo.service;

import com.yubo.model.Role;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/7 10:54
 */
public interface RoleCacheService {

    Role insert(Role role);

    Role getRole(Long id);

    int deleteRole(Long id);

    Role updateRole(Role role);

    void clear();
}
