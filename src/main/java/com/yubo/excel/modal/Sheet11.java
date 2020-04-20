package com.yubo.excel.modal;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yubo
 * @version V1.0
 * @description 非注解形式得自定义样式
 * @date 2020/4/17 14:39
 */
@ContentRowHeight(20)
@HeadRowHeight(30)
@ColumnWidth(25)
public class Sheet11 implements Serializable {
    private static final long serialVersionUID = -2192223807423411829L;

    @ExcelProperty(value = "姓名")
    private String name;
    @ExcelProperty(value = "年龄")
    private String age;
    @ExcelProperty(value = "日期")
    @DateTimeFormat(value = "yyyy年MM月dd日 HH:mm:SS")
    @ColumnWidth(value = 50)
    private Date date;

    public Sheet11() {
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

