package com.yubo.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author yubo
 * @version V1.0
 * @description 用户抢红包表
 * @date 2020/4/8 15:07
 */
public class UserRedPacket implements Serializable {
    private static final long serialVersionUID = -3038829948560809900L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 红包id
     */
    private Long redPacketId;
    /**
     * 抢红包的人编号
     */
    private Long userId;
    /**
     * 抢到的红包金额
     */
    private Double amount;
    /**
     * 抢红包时间
     */
    private Timestamp grabTime;
    /**
     * 备注
     */
    private String note;

    public UserRedPacket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRedPacketId() {
        return redPacketId;
    }

    public void setRedPacketId(Long redPacketId) {
        this.redPacketId = redPacketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Timestamp getGrabTime() {
        return grabTime;
    }

    public void setGrabTime(Timestamp grabTime) {
        this.grabTime = grabTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserRedPacket{");
        sb.append("id=").append(id);
        sb.append(", redPacketId=").append(redPacketId);
        sb.append(", userId=").append(userId);
        sb.append(", amount=").append(amount);
        sb.append(", grabTime=").append(grabTime);
        sb.append(", note='").append(note).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
