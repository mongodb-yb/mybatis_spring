package com.yubo.test;

import com.yubo.util.FileUtil;

import java.io.File;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/13 11:48
 */
public class FileTest {
    public static void main(String[] args) {
        String src = "C:\\Users\\Administrator\\Desktop\\哈哈哈\\Redis入门指南（第2版）-李子骅.pdf";
        String dest = "C:\\Users\\Administrator\\Desktop\\哈哈哈\\新建文件夹\\Redis入门指南（第2版）-李子骅.pdf";
        String srcPath = "C:\\Users\\Administrator\\Desktop\\哈哈哈";
        String outPath = "C:\\Users\\Administrator\\Desktop\\fast";
//        System.out.println(FileUtil.copyFile(src, dest, true));
//        System.out.println(FileUtil.zipFile(srcPath, outPath, "压缩文档.zip"));
        File file = new File("C:\\Users\\Administrator\\Desktop\\哈哈哈\\fff.txt");
        System.out.println(file.toURI());
    }
}
