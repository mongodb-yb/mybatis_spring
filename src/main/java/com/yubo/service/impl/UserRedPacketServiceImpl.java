package com.yubo.service.impl;

import com.yubo.dao.mapper.RedPacketMapper;
import com.yubo.dao.mapper.UserRedPacketMapper;
import com.yubo.model.RedPacket;
import com.yubo.model.UserRedPacket;
import com.yubo.service.UserRedPacketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/8 15:41
 */
@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {

    @Resource
    private UserRedPacketMapper userRedPacketMapper;

    @Resource
    private RedPacketMapper redPackMapper;

    private static final int FAILED = 0;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insertUserRedPacket(Long redPacketId, Long userId) {

//        long start = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        for (int i = 0; i < 10; i++) {
//            long end = System.currentTimeMillis();
//            if ((end - start) > 100) {
//                return FAILED;
//            }
            // 获取红包信息
            RedPacket redPacket = redPackMapper.getRedPacket(redPacketId);
            if (redPacket.getStock() > 0) {
                int update = redPackMapper.decreaseRedPacket(redPacketId, redPacket.getVersion());
                if (update == 0) {
                    continue;
                }
                // 生成抢红包信息
                UserRedPacket userRedPacket = new UserRedPacket();
                userRedPacket.setUserId(userId);
                System.out.println("抢红包的用户为" + userId + "========================================");
                userRedPacket.setRedPacketId(redPacketId);
                userRedPacket.setAmount(redPacket.getUnitAmount());
                userRedPacket.setNote("抢红包" + redPacketId);
                return userRedPacketMapper.insertUserRedPacket(userRedPacket);
            }
            return FAILED;
        }
        return FAILED;
    }
}
