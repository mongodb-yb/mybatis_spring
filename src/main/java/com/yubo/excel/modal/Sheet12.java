package com.yubo.excel.modal;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.io.Serializable;

/**
 * @author yubo
 * @version V1.0
 * @description staff的excel映射实体
 * @date 2020/4/16 11:28
 */

public class Sheet12 implements Serializable {
    private static final long serialVersionUID = 3628202654259163929L;

    @ExcelProperty(value = "姓名")
    private String name;
    @ExcelProperty(value = "手机")
    private String mobile;
    @ExcelProperty(value = "年龄")
    private String age;

    public Sheet12() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
