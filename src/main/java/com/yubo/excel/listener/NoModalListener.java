package com.yubo.excel.listener;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yubo
 * @version V1.0
 * @description 不用对象映射excel数据
 * @date 2020/4/17 9:41
 */
public class NoModalListener extends AnalysisEventListener<Map<Integer, String>> {
    private static final Logger log = Logger.getLogger(NoModalListener.class);

    private final Gson gson = new Gson();
    private JsonParser jsonParser = new JsonParser();
    private JsonObject jsonObject = new JsonObject();
    private String idCard;
    private String status;
    private String line;
    private List<List<String>> writeList = new ArrayList<>();

    @Override
    public void invoke(Map<Integer, String> objectMap, AnalysisContext analysisContext) {
        int num = 0;
        for (Map.Entry entry : objectMap.entrySet()) {
            String jsonStr = (String) entry.getValue();
            jsonObject = jsonParser.parse(jsonStr).getAsJsonObject();
            idCard = jsonObject.get("data").getAsJsonObject().get("key").getAsString();
            status = jsonObject.get("data").getAsJsonObject().get("status").getAsString();
            List<String> data = new ArrayList<>();
            data.add(idCard);
            data.add(status);
            writeList.add(data);
            num++;
            System.out.println("读取第" + num + "行");

        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        String filePath = "C:\\Users\\Administrator\\Desktop\\test\\新建 Microsoft Excel 工作表.xlsx";
        System.out.println("集合大小为" + writeList.size());
        EasyExcel.write(filePath).sheet().head(headInfo()).doWrite(writeList);
    }

    private List<List<String>> headInfo() {
        List<List<String>> lists = new ArrayList<>();
        List<String> head0 = new ArrayList<>();
        head0.add("idCard");
        List<String> head1 = new ArrayList<>();
        head1.add("status");
        lists.add(head0);
        lists.add(head1);
        return lists;
    }

}
