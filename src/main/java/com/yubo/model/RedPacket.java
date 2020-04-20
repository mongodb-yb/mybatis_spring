package com.yubo.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author yubo
 * @version V1.0
 * @description 红包
 * @date 2020/4/8 15:03
 */
public class RedPacket implements Serializable {
    private static final long serialVersionUID = -1036219753231830460L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 发红包的人
     */
    private Long userId;
    /**
     * 红包金额
     */
    private Double amount;
    /**
     * 红包发送时间
     */
    private Timestamp sendTime;
    /**
     * 红包数量
     */
    private Integer total;
    /**
     * 每个红包的金额
     */
    private Double unitAmount;
    /**
     * 小红包剩余数量
     */
    private Integer stock;
    /**
     * 非业务字段-乐观锁
     */
    private Integer version;

    /**
     * 备注
     */
    private String note;

    public RedPacket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Double getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(Double unitAmount) {
        this.unitAmount = unitAmount;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RedPacket{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", amount=").append(amount);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", total=").append(total);
        sb.append(", unitAmount=").append(unitAmount);
        sb.append(", stock=").append(stock);
        sb.append(", note='").append(note).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
