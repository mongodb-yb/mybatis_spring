import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.yubo.excel.listener.NoModalListener;
import com.yubo.excel.listener.ObjectListener;
import com.yubo.excel.listener.ObjectListener2;
import com.yubo.excel.modal.Sheet12;
import com.yubo.excel.modal.Sheet3;
import com.yubo.excel.modal.Sheet4;
import com.yubo.excel.modal.Sheet5Exception;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/16 10:32
 */

public class EasyExcelReadTest extends BaseTest {

    private String fileName = "C:\\Users\\Administrator\\Desktop\\excel\\staff.xlsx";
    // 行读取监听
    private ObjectListener listener = new ObjectListener();

    /**
     * {@link Sheet12}
     */
    @Test
    public void simpleRead() {
        // 默认读取第一个sheet()，下标从0开始
//        EasyExcel.read(fileName, Staff.class, listener).sheet(1).doRead();

        // 写法2
        ExcelReader excelReader = EasyExcel.read(fileName, Sheet12.class, listener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).head(Sheet3.class).registerReadListener(new ObjectListener2()).build();
        excelReader.read(readSheet);
        // 必须关闭，可能导致磁盘崩溃
        excelReader.finish();
    }

    /**
     * 读取多个sheet：
     * 读取多个sheet或者全部读取，注意一个sheet不能重复读取，重复读取必须重新读取文件
     * 每次读完一个sheet，监听器的doAfterAllAnalysed 方法就被执行一次
     */
    @Test
    public void readMoreSheet() {
        // 方法一 指定那个类去读，然后读取全部sheet，文件流自动关闭
        // EasyExcel.read(fileName, Staff.class, listener).doReadAll();
        // 方法二:在使用同一套监听器和head头的时候，当然可以使用上面的那个方法读取多个sheet
        // 也可以每个sheet使用不同的head和监听器。如下：
        // 如果使用该种配置，则会又两个监听，每次读取一个sheet，则会触发两个监听的逻辑。
        // ExcelReader excelReader = EasyExcel.read(fileName, Staff.class, listener).build();
        // 使用一个监听的话就使用如下的配置
        ExcelReader excelReader = EasyExcel.read(fileName).build();
        ReadSheet sheet1 = EasyExcel.readSheet(0).head(Sheet12.class).registerReadListener(listener).build();
        ReadSheet sheet3 = EasyExcel.readSheet(2).head(Sheet3.class).registerReadListener(new ObjectListener2()).build();
        // 将sheet全部传入
        excelReader.read(sheet1, sheet3);
        excelReader.finish();
    }

    /**
     * 日期、数字、或者自定义转换格式：java的类型和excel的数据类型必须保持一致，否则会出异常
     */
    @Test
    public void regix() {
        // 局部转换器
        EasyExcel.read(fileName, Sheet4.class, listener).sheet(3).doRead();
        // 全局转换器  暂时有问题
//        ExcelReader reader = EasyExcel.read(fileName, Sheet4.class, listener).build();
//        ReadSheet readSheet = EasyExcel.readSheet(3).registerConverter(new StringConverter()).build();
//        reader.read(readSheet);
//        reader.finish();
//        EasyExcel.read(fileName, Sheet12.class, listener).registerConverter(new StringConverter()).sheet().doRead();
    }

    /**
     * 多行头：意思是标题在excel的第几行
     */
    @Test
    public void moreHead() {
        // 标题在excel的第几行
        EasyExcel.read(fileName, Sheet4.class, listener).sheet(3).headRowNumber(7).doRead();
    }

    /**
     * 同步读取返回：不推荐使用，会把大量的数据放到内存里
     */
    @Test
    public void synchronizedRead() {

    }

    /**
     * 读取表头信息
     */
    @Test
    public void readHeadInfo() {
        // 读取表头信息
        // 在监听器重重写invokeHead方法，参数headMap存储了表头的信息
        EasyExcel.read(fileName, Sheet4.class, listener).sheet(3).headRowNumber(7).doRead();
    }

    /**
     * 自定义数据转换格式：如果异常，可以进行异常处理
     */
    @Test
    public void convertExceptionHandlerTest() {

        ExcelReader excelReader = EasyExcel.read(fileName).build();
        ReadSheet readSheet = EasyExcel.readSheet(4).registerReadListener(listener).head(Sheet5Exception.class).build();
        excelReader.read(readSheet);
        excelReader.finish();
    }

    /**
     * 不创建对象的读取excel 读取到的每行数据都是个key-value格式，所以可以用map接收,
     * 每一行都是一个数组
     */
    @Test
    public void noModalRead() {
        String fileName = "C:\\Users\\Administrator\\Desktop\\test\\NO_DATA.xlsx";
        EasyExcel.read(fileName, new NoModalListener()).sheet().doRead();
    }

    /**
     * controller接收MultiPartFile参数读取excel
     */
    @Test
    public void controllerReadTest() {
        MultipartFile multipartFile = null;
        try {
            EasyExcel.read(multipartFile.getInputStream(), new NoModalListener()).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
