package com.yubo.excel.modal;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentLoopMerge;
import com.alibaba.excel.annotation.write.style.OnceAbsoluteMerge;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yubo
 * @version V1.0
 * @description 注解的形式合并单元格
 * @date 2020/4/17 16:12
 */
// 将6、7行的2、3列合并单元格。下标从0开始

@OnceAbsoluteMerge(firstRowIndex = 5, lastRowIndex = 6, firstColumnIndex = 1, lastColumnIndex = 2)
public class Sheet13 implements Serializable {
    private static final long serialVersionUID = 1102073093582872220L;
    // 几行合并，几列合并
//    @ContentLoopMerge(eachRow = 2, columnExtend = 2)
    @ExcelProperty(value = "姓名")
    private String name;
    @ExcelProperty(value = "年龄")
    private String age;
    @ExcelProperty(value = "日期")
    @DateTimeFormat(value = "yyyy年MM月dd日 HH:mm:SS")
    @ColumnWidth(value = 50)
    private Date date;

    public Sheet13() {
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
