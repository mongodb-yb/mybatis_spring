package com.yubo.service.impl;

import com.yubo.dao.mapper.RedPacketMapper;
import com.yubo.model.RedPacket;
import com.yubo.service.RedPacketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/8 15:38
 */
@Service
public class RedPacketServiceImpl implements RedPacketService {

    @Resource
    private RedPacketMapper redPackMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public RedPacket getRedPacket(Long id) {
        return redPackMapper.getRedPacket(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int decreaseRedPacket(Long id, Integer version) {
        return redPackMapper.decreaseRedPacket(id, version);
    }
}
