package com.yubo.excel.modal;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yubo
 * @version V1.0
 * @description 指定字段卸载哪一列
 * @date 2020/4/17 11:00
 */
public class Sheet6 implements Serializable {
    private static final long serialVersionUID = 2249249115518122601L;

    @ExcelProperty(value = "姓名", index = 3)
    private String name;
    @ExcelProperty(value = "年龄", index = 1)
    private String age;
    @ExcelProperty(value = "生日", index = 5)
    private Date date;

    /**
     * 忽略输出字段
     */
    @ExcelIgnore
    private String ignore;

    public Sheet6() {
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
