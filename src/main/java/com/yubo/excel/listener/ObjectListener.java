package com.yubo.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/16 11:29
 */
public class ObjectListener extends AnalysisEventListener {
    private static final Logger logger = Logger.getLogger(ObjectListener.class);

    private Gson gson = new Gson();
    private int count = 0;

    /**
     * 每一条数据解析都会来调用该方法
     *
     * @param object
     * @param analysisContext
     */
    @Override
    public void invoke(Object object, AnalysisContext analysisContext) {
        logger.info(gson.toJson(object));
        count++;
    }

    /**
     * 当一个sheet的数据解析完了以后，就会调用该方法
     *
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        logger.info("解析了" + count + "行excel数据");
    }

    /**
     * 读取表头数据：表头的名称、类型等
     *
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHead(Map headMap, AnalysisContext context) {
        super.invokeHead(headMap, context);
        logger.info("读取到了表头数据：" + gson.toJson(headMap));
    }

    /**
     * excel映射实体时，出现异常的处理方法
     * 抛出异常则停止读取。 throws Exception
     * 如果这里不抛出异常则 继续读取下一行。
     *
     * @param exception
     * @param context
     * @throws Exception
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) {
        logger.error("excel映射实体失败，继续映射下一行：" + exception.getMessage());
        // 如果是某一个单元格的转换异常 能获取到具体行号
        // 如果要获取头的信息 配合invokeHeadMap使用
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException excelDataConvertException = (ExcelDataConvertException) exception;
            // 第几行出现异常
            int rowIndex = excelDataConvertException.getRowIndex();
            // 第几列出现异常
            int columnIndex = excelDataConvertException.getColumnIndex();
            logger.error("第" + rowIndex + "行 第" + columnIndex + "列出现异常");
        }
    }
}
