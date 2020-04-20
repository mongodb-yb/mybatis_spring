package com.yubo.service;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/8 15:40
 */
public interface UserRedPacketService {

    /**
     * 保存抢红包信息
     *
     * @param redPacketId
     * @param userId
     * @return
     */
    int insertUserRedPacket(Long redPacketId, Long userId);
}
