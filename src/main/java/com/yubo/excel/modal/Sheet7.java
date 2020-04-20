package com.yubo.excel.modal;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yubo
 * @version V1.0
 * @description 复杂的标题头写入
 * @date 2020/4/17 11:07
 */
public class Sheet7 implements Serializable {
    private static final long serialVersionUID = 9035992356546128553L;

    @ExcelProperty(value = {"余波的excel", "姓名"}, index = 2)
    private String name;
    @ExcelProperty(value = {"余波的excel", "年龄"}, index = 5)
    private String age;
    @ExcelProperty(value = {"蔡蔡", "生日"}, index = 8)
    private Date date;

    /**
     * 忽略输出字段
     */
    @ExcelIgnore
    private String ignore;

    public Sheet7() {
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
