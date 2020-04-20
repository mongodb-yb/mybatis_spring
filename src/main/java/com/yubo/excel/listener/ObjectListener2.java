package com.yubo.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/16 11:29
 */
public class ObjectListener2 extends AnalysisEventListener {
    private static final Logger logger = Logger.getLogger(ObjectListener2.class);

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
        logger.info("hahahahah解析了" + count + "行excel数据");
    }
}
