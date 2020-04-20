package com.yubo.excel.modal;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.yubo.excel.convert.StringConverter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yubo
 * @version V1.0
 * @description 格式化输出字段
 * @date 2020/4/17 11:54
 */
public class Sheet8 implements Serializable {
    private static final long serialVersionUID = -4531323396356593650L;
    @ExcelProperty(value = "姓名", converter = StringConverter.class)
    private String name;

    @ExcelProperty(value = "年龄")
    private String age;

    @ExcelProperty(value = "日期")
    @DateTimeFormat("yyyy年MM月dd日 HH时:mm分:ss秒")
    private Date date;

    @ExcelProperty(value = "金额")
    // #字代表原数值
    @NumberFormat(value = "#")
    private Double money;

    public Sheet8() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
