package com.yubo.excel.modal;

import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/16 17:29
 */
public class Sheet5Exception implements Serializable {
    private static final long serialVersionUID = 3853574419969111008L;
    @ExcelProperty(value = "姓名")
    private String name;
    @ExcelProperty(value = "年龄")
    private String age;
    @ExcelProperty(value = "日期")
    // 和excel类型不同，进行异常测试
    private Date date;

    public Sheet5Exception() {
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
}
