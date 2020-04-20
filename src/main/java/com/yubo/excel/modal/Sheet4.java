package com.yubo.excel.modal;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.yubo.excel.convert.StringConverter;

import java.io.Serializable;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/16 16:01
 */
public class Sheet4 implements Serializable {
    private static final long serialVersionUID = -1607077730374727262L;
    // 局部转换器--只作用于该字段
    @ExcelProperty(value = "姓名")
    private String name;
    @ExcelProperty(value = "年龄")
    private String age;
    @ExcelProperty(value = "生日")
    @DateTimeFormat(value = "yyyy年MM月dd日")
    private String date;
    @ExcelProperty(value = "金钱")
//    @NumberFormat(value = "##%")
    private String doubleMoney;

    public Sheet4() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoubleMoney() {
        return doubleMoney;
    }

    public void setDoubleMoney(String doubleMoney) {
        this.doubleMoney = doubleMoney;
    }
}
