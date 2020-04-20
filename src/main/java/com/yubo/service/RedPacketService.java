package com.yubo.service;

import com.yubo.model.RedPacket;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/8 15:37
 */
public interface RedPacketService {

    RedPacket getRedPacket(Long id);

    int decreaseRedPacket(Long id, Integer version);
}
