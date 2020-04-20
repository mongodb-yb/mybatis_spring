package com.yubo.service.impl;

import com.yubo.dao.mapper.RoleCacheMapper;
import com.yubo.model.Role;
import com.yubo.service.RoleCacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/7 10:56
 */
@Service
public class RoleCacheServiceImpl implements RoleCacheService {

    @Resource
    private RoleCacheMapper roleCacheMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @CachePut(value = "common", key = "'Role:'+#role.id")
    public Role insert(Role role) {
        roleCacheMapper.insert(role);
        return role;
    }

    @Override
    @Cacheable(value = "common", key = "'Role:'+#id")
    public Role getRole(Long id) {
        return roleCacheMapper.getRole(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @CacheEvict(value = "common", key = "'Role:'+#id")
    public int deleteRole(Long id) {
        return roleCacheMapper.deleteRole(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @CachePut(value = "common", key = "'Role:'+#role.id")
    public Role updateRole(Role role) {
        roleCacheMapper.updateRole(role);
        return role;
    }

    @Override
    @CacheEvict(value = "common", key = "'*'")
    public void clear() {

    }
}
