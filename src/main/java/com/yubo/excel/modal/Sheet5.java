package com.yubo.excel.modal;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yubo
 * @version V1.0
 * @description 写excel
 * @date 2020/4/17 10:20
 */
public class Sheet5 implements Serializable {
    private static final long serialVersionUID = 4967150459822934657L;

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

    public Sheet5() {
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
