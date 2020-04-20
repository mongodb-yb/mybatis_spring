package com.yubo.excel.modal;

import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/16 15:24
 */
public class Sheet3 implements Serializable {
    private static final long serialVersionUID = 5305003056794166440L;

    @ExcelProperty(index = 0)
    private String spring;
    @ExcelProperty(index = 1)
    private String summer;
    @ExcelProperty(index = 2)
    private String automn;
    @ExcelProperty(index = 3)
    private String winter;

    public Sheet3() {
    }

    public String getSpring() {
        return spring;
    }

    public void setSpring(String spring) {
        this.spring = spring;
    }

    public String getSummer() {
        return summer;
    }

    public void setSummer(String summer) {
        this.summer = summer;
    }

    public String getAutomn() {
        return automn;
    }

    public void setAutomn(String automn) {
        this.automn = automn;
    }

    public String getWinter() {
        return winter;
    }

    public void setWinter(String winter) {
        this.winter = winter;
    }
}
