package com.yubo.excel.modal;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yubo
 * @version V1.0
 * @description table的方式写入
 * @date 2020/4/17 11:07
 */
public class Sheet14 implements Serializable {
    private static final long serialVersionUID = 9035992356546128553L;

    @ExcelProperty(value = "姓名")
    private String name;
    @ExcelProperty(value = "年龄")
    private String age;
    @ExcelProperty(value = "生日")
    private Date date;

    /**
     * 忽略输出字段
     */
    @ExcelIgnore
    private String ignore;

    public Sheet14() {
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

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }
}
