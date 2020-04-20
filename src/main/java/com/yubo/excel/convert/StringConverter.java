package com.yubo.excel.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @author yubo
 * @version V1.0
 * @description 自定义格式转换器--以String为例
 * @date 2020/4/16 16:14
 */
public class StringConverter implements Converter<String> {

    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return null;
    }

    /**
     * 读取excel时调用的方法
     *
     * @param cellData
     * @param excelContentProperty
     * @param globalConfiguration
     * @return
     * @throws Exception
     */
    @Override
    public String convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String value = cellData.getStringValue();
        return "自定义的 " + value;
    }

    /**
     * 写出excel时调用的方法
     *
     * @param string
     * @param excelContentProperty
     * @param globalConfiguration
     * @return
     * @throws Exception
     */
    @Override
    public CellData convertToExcelData(String string, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String value = "自定义的：" + string;
        return new CellData(value);
    }
}
