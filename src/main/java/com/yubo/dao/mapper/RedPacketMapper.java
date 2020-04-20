package com.yubo.dao.mapper;

import com.yubo.model.RedPacket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/8 15:13
 */
@Mapper
public interface RedPacketMapper {

    RedPacket getRedPacket(Long id);

    int decreaseRedPacket(@Param("id") Long id, @Param("version") Integer version);
}
