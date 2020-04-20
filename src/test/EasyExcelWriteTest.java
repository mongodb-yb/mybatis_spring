import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.yubo.excel.modal.Sheet10;
import com.yubo.excel.modal.Sheet11;
import com.yubo.excel.modal.Sheet13;
import com.yubo.excel.modal.Sheet14;
import com.yubo.excel.modal.Sheet5;
import com.yubo.excel.modal.Sheet6;
import com.yubo.excel.modal.Sheet7;
import com.yubo.excel.modal.Sheet8;
import com.yubo.excel.modal.Sheet9;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/17 10:17
 */
public class EasyExcelWriteTest extends BaseTest {

    /**
     * 数据写出的excel路径
     */
    private final String filePath = "C:\\Users\\Administrator\\Desktop\\excel\\test.xlsx";

    /**
     * 生成输出数据
     *
     * @return
     */
    private List<Sheet5> getData() {
        List<Sheet5> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sheet5 data = new Sheet5();
            data.setName("神舟" + (i + 1) + "号");
            data.setAge((i + 10) + "");
            data.setDate(new Date());
            datas.add(data);
        }
        return datas;
    }

    /**
     * 生成输出数据
     *
     * @return
     */
    private List<Sheet6> getData6() {
        List<Sheet6> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sheet6 data = new Sheet6();
            data.setName("神舟" + (i + 1) + "号");
            data.setAge((i + 10) + "");
            data.setDate(new Date());
            datas.add(data);
        }
        return datas;
    }

    /**
     * 生成输出数据
     *
     * @return
     */
    private List<Sheet7> getData7() {
        List<Sheet7> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sheet7 data = new Sheet7();
            data.setName("神舟" + (i + 1) + "号");
            data.setAge((i + 10) + "");
            data.setDate(new Date());
            datas.add(data);
        }
        return datas;
    }

    /**
     * 生成输出数据
     *
     * @return
     */
    private List<Sheet8> getData8() {
        List<Sheet8> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sheet8 data = new Sheet8();
            data.setName("神舟" + (i + 1) + "号");
            data.setAge((i + 10) + "");
            data.setDate(new Date());
            data.setMoney((10 + i) * 1e0d);
            datas.add(data);
        }
        return datas;
    }

    /**
     * 生成输出数据
     *
     * @return
     */
    private List<Sheet9> getData9() {
        List<Sheet9> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sheet9 data = new Sheet9();
            data.setName("神舟" + (i + 1) + "号");
            data.setAge((i + 10) + "");
            data.setDate(new Date());
            datas.add(data);
        }
        return datas;
    }

    /**
     * 生成输出数据
     *
     * @return
     */
    private List<Sheet10> getData10() {
        List<Sheet10> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sheet10 data = new Sheet10();
            data.setName("神舟" + (i + 1) + "号");
            data.setAge((i + 10) + "");
            data.setDate(new Date());
            datas.add(data);
        }
        return datas;
    }


    /**
     * 生成输出数据
     *
     * @return
     */
    private List<Sheet11> getData11() {
        List<Sheet11> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sheet11 data = new Sheet11();
            data.setName("神舟" + (i + 1) + "号");
            data.setAge((i + 10) + "");
            data.setDate(new Date());
            datas.add(data);
        }
        return datas;
    }

    /**
     * 生成输出数据
     *
     * @return
     */
    private List<Sheet13> getData13() {
        List<Sheet13> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sheet13 data = new Sheet13();
            data.setName("神舟" + (i + 1) + "号");
            data.setAge((i + 10) + "");
            data.setDate(new Date());
            datas.add(data);
        }
        return datas;
    }

    /**
     * 生成输出数据
     *
     * @return
     */
    private List<Sheet14> getData14() {
        List<Sheet14> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sheet14 data = new Sheet14();
            data.setName("神舟" + (i + 1) + "号");
            data.setAge((i + 10) + "");
            data.setDate(new Date());
            datas.add(data);
        }
        return datas;
    }

    /**
     * 生成输出数据
     *
     * @return
     */
    private List<Sheet14> getLogData14() {
        List<Sheet14> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sheet14 data = new Sheet14();
            data.setName("神舟神舟神舟神舟神舟神舟神舟神舟神舟神舟神舟神舟神舟神舟" + (i + 1) + "号");
            data.setAge((i + 10) + "");
            data.setDate(new Date());
            datas.add(data);
        }
        return datas;
    }

    /**
     * 简单的写之写法一
     */
    @Test
    public void simpleWrite1() {
        // 写出路径、哪个实体class去写、创建的excel类型、sheet的名字、写出list数据
        EasyExcel.write(filePath, Sheet5.class).excelType(ExcelTypeEnum.XLSX).sheet(2, "哈哈").doWrite(getData());
    }

    /**
     * 简单的写之写法二
     */
    @Test
    public void simpleWrite2() {
        ExcelWriter excelWriter = EasyExcel.write(filePath, Sheet5.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet(3).build();
        excelWriter.write(getData(), writeSheet);
        excelWriter.finish();
    }

    /**
     * 忽略某个字段写入excel
     */
    @Test
    public void excludeColumn() {
        // 添加不写入excel的字段
        Set<String> excludeColumns = new HashSet<>();
        excludeColumns.add("date");
        EasyExcel.write(filePath, Sheet5.class)
                .excludeColumnFiledNames(excludeColumns)
                .sheet("忽略了date字段")
                .doWrite(getData());
    }

    /**
     * 只输出某些字段到excel
     */
    @Test
    public void includeSomeColumn() {
        // 只输出name和生日字段
        Set<String> includeSomeColumn = new HashSet<>();
        includeSomeColumn.add("name");
        includeSomeColumn.add("date");
        EasyExcel.write(filePath, Sheet5.class)
                .includeColumnFiledNames(includeSomeColumn)
                .sheet(5, "只输出name和date字段的内容")
                .doWrite(getData());
    }

    /**
     * 指定字段写在excel的哪一列:在对应的modal的字段中添加index，默认从0开始
     */
    @Test
    public void indexWrite() {
        EasyExcel.write(filePath, Sheet6.class)
                .sheet("指定字段写在哪个列")
                .doWrite(getData6());
    }

    /**
     * 复杂的标题头写入
     */
    @Test
    public void complexHeadTest() {

        EasyExcel.write(filePath, Sheet7.class)
                .sheet("复杂标题头")
                .doWrite(getData7());

    }

    /**
     * 复杂的标题头+指定列写入
     */
    @Test
    public void complexHeadAndIndexWriteTest() {

        EasyExcel.write(filePath, Sheet7.class)
                .sheet("复杂标题头")
                .doWrite(getData7());
    }

    /**
     * 重复写入(同一个对象重复写入一个sheet中)
     */
    @Test
    public void repeatedtWriteTest() {
        ExcelWriter excelWriter = EasyExcel.write(filePath, Sheet5.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("重复写入一个sheet").build();
        for (int i = 0; i < 5; i++) {
            excelWriter.write(getData(), writeSheet);
        }
        excelWriter.finish();
    }

    /**
     * 同同一个对象写入多个sheet中
     */
    @Test
    public void oneModalTomoreSheetWriteTest() {
        ExcelWriter excelWriter = EasyExcel.write(filePath, Sheet5.class).build();
        WriteSheet writeSheet = null;
        for (int i = 0; i < 5; i++) {
            // 循环创建WriteSheet对象，sheet必须起名字，且名字不一样
            writeSheet = EasyExcel.writerSheet("sheet" + i).build();
            excelWriter.write(getData(), writeSheet);
        }
        excelWriter.finish();
    }

    /**
     * 不同的对象写入不同的sheet
     */
    @Test
    public void moreModalToMoreSheetWriteTest() {
        ExcelWriter excelWriter = EasyExcel.write(filePath).build();
        String strClass = "sheet5";
        WriteSheet writeSheet;
        for (int i = 0; i < 5; i++) {
            if (strClass.equals("sheet5")) {
                // head方法传入不同的class对象
                writeSheet = EasyExcel.writerSheet("sheet" + i + strClass).head(Sheet5.class).build();
                // 获取class对象的集合数据
                excelWriter.write(getData(), writeSheet);
                strClass = "sheet6";
            }
            if (strClass.equals("sheet6")) {
                // head方法传入不同的class对象
                writeSheet = EasyExcel.writerSheet("sheet" + i + strClass).head(Sheet6.class).build();
                // 获取class对象的集合数据
                excelWriter.write(getData6(), writeSheet);
                strClass = "";
            }
        }
        excelWriter.finish();
    }

    /**
     * 格式化字段输出
     */
    @Test
    public void regixColumn() {

        EasyExcel.write(filePath, Sheet8.class)
                .sheet("格式化字段输出")
                .doWrite(getData8());
    }

    /**
     * 将另一个excel的内容与你要写的excel的数据合并在一起，如果指定了sheet方法的参数，则会产生多个sheet
     */
    @Test
    public void templateTest() {
        String templatePath = "C:\\Users\\Administrator\\Desktop\\excel\\tenplate.xlsx";
        EasyExcel.write(filePath, Sheet8.class)
                .withTemplate(templatePath)
                .sheet()
                .doWrite(getData8());
    }

    /**
     * 行高列宽测试
     */
    @Test
    public void roeHeightColumnWidthTest() {
        EasyExcel.write(filePath, Sheet9.class)
                .sheet()
                .doWrite(getData9());
    }

    /**
     * 注解形式自定义样式--只有在2.2.0-beta1或者beta2的jar包里才有
     * HeadStyle
     * HeadFontStyle
     * ContentStyle
     * ContentFontStyle
     */
    @Test
    public void annotationStyleWriteTest() {

        EasyExcel.write(filePath, Sheet10.class)
                .sheet()
                .doWrite(getData10());
//        IndexedColors
    }

    /**
     * 自定义样式，不使用样式注解
     * 1、创建excel实体对象
     * 2、创建style策略，并注册
     * 3、直接写出到excel
     */
    @Test
    public void selfDefineStyleWriteTest() {
        // 头的策略
        WriteCellStyle headStyle = new WriteCellStyle();
        // 背景为红色
        headStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        // 头字体
        WriteFont headFont = new WriteFont();
        headFont.setFontHeightInPoints((short) 20);
        headFont.setFontName("微软雅黑");
        // 添加头字体
        headStyle.setWriteFont(headFont);

        // 内容策略
        WriteCellStyle contentStyle = new WriteCellStyle();
        // 需要指定背景色的格式：点点的，还是实体的
        contentStyle.setFillPatternType(FillPatternType.BRICKS);
        contentStyle.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
        // 内容字体
        WriteFont contentFont = new WriteFont();
        contentFont.setFontName("微软雅黑");
        contentFont.setFontHeightInPoints((short) 15);
        // 添加内容字体
        contentStyle.setWriteFont(contentFont);

        // 上面的策略中：头和内容是分开的。可以自己添加其他的。
        HorizontalCellStyleStrategy styleStrategy = new HorizontalCellStyleStrategy(headStyle, contentStyle);
        // 直接写
        EasyExcel.write(filePath, Sheet10.class).sheet().doWrite(getData11());
    }

    /**
     * 注解合并单元格
     * 合并集合，合并几列，合并哪个具体的单元格 3种情况
     */
    @Test
    public void annotationMerge() {
        EasyExcel.write(filePath, Sheet13.class).sheet().doWrite(getData13());
    }


    /**
     * table的方式写入
     */
    @Test
    public void tableWriteTest() {
        ExcelWriter excelWriter = EasyExcel.write(filePath, Sheet14.class).build();
        // 把sheet设置为不需要头 不然会输出sheet的头 这样看起来第一个table 就有2个头了
        WriteSheet writeSheet = EasyExcel.writerSheet(0).needHead(Boolean.FALSE).build();
        // 设置table，必须指定需要头，table 会继承sheet的配置，sheet配置了不需要，table 默认也是不需要
        WriteTable writeTable1 = EasyExcel.writerTable(0).needHead(Boolean.TRUE).build();
        WriteTable writeTable2 = EasyExcel.writerTable(1).needHead(Boolean.TRUE).build();
        // 每次写入都会写入头，然后在头的下面写，类似于表格
        excelWriter.write(getData14(), writeSheet, writeTable1);
        excelWriter.write(getData14(), writeSheet, writeTable2);
        excelWriter.finish();
    }


    /**
     * 动态的写头,和实体Sheet14中的字段上的@ExcelProperty没有关系了，即注解不起作用了。
     */
    @Test
    public void dynamicHeadWriteTest() {
        EasyExcel.write(filePath)
                // 这里放入动态头
                .head(head()).sheet("模板")
                // 当然这里数据也可以用 List<List<String>> 去传入
                .doWrite(getData14());
    }

    private List<List<String>> head() {

        List<List<String>> list = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<String>();
        head0.add("字符串" + System.currentTimeMillis());
        List<String> head1 = new ArrayList<String>();
        head1.add("数字" + System.currentTimeMillis());
        List<String> head2 = new ArrayList<String>();
        head2.add("日期" + System.currentTimeMillis());
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }

    /**
     * 自动匹配列宽--还不太准确
     */
    @Test
    public void longAntoMatchColumnWidthWriteTest() {
        EasyExcel.write(filePath, Sheet14.class).
                sheet("模板")
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .doWrite(getLogData14());
    }


    /**
     * 自定义写excel的拦截器
     */
    @Test
    public void writeInterceptorTest() {

    }


    /**
     * 无对象写excel
     * 和动态的写头信息相似
     */
    @Test
    public void noModalWrite() {
        EasyExcel.write(filePath).sheet().head(headInfo()).doWrite(contentInfo());
    }

    /**
     * 头信息
     *
     * @return
     */
    private List<List<String>> headInfo() {
        List<List<String>> head = new ArrayList<>();
        List<String> head0 = new ArrayList<>();
        head0.add("姓名");
        List<String> head1 = new ArrayList<>();
        head1.add("年龄");
        List<String> head2 = new ArrayList<>();
        head2.add("日期");
        head.add(head0);
        head.add(head1);
        head.add(head2);
        return head;
    }

    /**
     * 内容信息
     *
     * @return
     */
    private List<List<Object>> contentInfo() {
        List<List<Object>> contentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Object> data = new ArrayList<>();
            data.add("神州" + (i + 1) + "号");
            data.add(i + 5);
            data.add(new Date());
            contentList.add(data);
        }
        return contentList;
    }

    @Test
    public void controllerWriteTest(){

    }

}
