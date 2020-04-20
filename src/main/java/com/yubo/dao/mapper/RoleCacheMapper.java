package com.yubo.dao.mapper;

import com.yubo.model.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/7 10:57
 */
@Mapper
public interface RoleCacheMapper {
    int insert(Role role);

    Role getRole(Long id);

    int deleteRole(Long id);

    int updateRole(Role role);
}
