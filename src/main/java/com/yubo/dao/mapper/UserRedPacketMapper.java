package com.yubo.dao.mapper;

import com.yubo.model.UserRedPacket;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/8 15:29
 */
@Mapper
public interface UserRedPacketMapper {

    int insertUserRedPacket(UserRedPacket userRedPacket);

}
