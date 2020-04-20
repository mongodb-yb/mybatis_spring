package com.yubo.util;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author yubo
 * @version V1.0
 * @description 文件操作类
 * @date 2020/4/13 11:22
 */
public class FileUtil {
    private static final Logger log = Logger.getLogger(FileUtil.class);

    /**
     * 拷贝文件
     *
     * @param srcFile  源文件
     * @param destFile 复制品
     * @param overlay  是否覆盖
     * @return
     */
    public static boolean copyFile(String srcFile, String destFile, boolean overlay) {
        // 源文件
        File src = new File(srcFile);
        // 目标文件
        File dest = new File(destFile);

        // 源文件判断
        if (!src.exists()) {
            log.info("源文件不存在");
            return false;
        } else if (!src.isFile()) {
            log.info("源文件不是一个文件");
            return false;
        }

        // 目标文件判断
        if (dest.exists()) {
            // 删除已经存在的目标文件
            if (overlay) {
                try {
                    FileUtils.forceDelete(new File(destFile));
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        } else {
            // 目标文件目录是否存在
            if (!dest.getParentFile().exists()) {
                // 不存在则创建目录
                if (!dest.getParentFile().mkdir()) {
                    // 创建失败则返回
                    return false;
                }
            }
        }

        // 开始拷贝
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(src);
            outputStream = new FileOutputStream(dest);
            byte[] bytes = new byte[1024];
            int line;
            while ((line = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 将存放在srcFilePath目录路径下的文件，打包成zipName名字的压缩文件，并存放到zipFilePath目录路径下
     *
     * @param srcFilePath 源文件所在目录路径
     * @param zipFilePath 压缩文件存放位置
     * @param zipName     压缩文件名
     * @return
     */
    public static boolean zipFile(String srcFilePath, String zipFilePath, String zipName) {
        // 待压缩文件夹
        File srcFile = new File(srcFilePath);
        if (!srcFile.exists()) {
            log.info("源文件不存在");
        } else {
            ZipOutputStream zipOutputStream = null;
            try {
                File zipFile = new File(zipFilePath + "/" + zipName);
                if (zipFile.exists()) {
                    log.info("存在目标压缩文件");
                } else {
                    File[] srcFiles = srcFile.listFiles();
                    if (srcFiles == null && srcFiles.length < 1) {
                        log.info("不存在源文件进行压缩");
                    }
                    // 创建一个空的zip文件
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
//                    zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFile)));
                    byte[] bytes = new byte[10240];
                    for (File srcFile1 : srcFiles) {
                        // 创建源文件的zip条目
                        ZipEntry zipEntry = new ZipEntry(srcFile1.getName());
                        zipOutputStream.putNextEntry(zipEntry);
                        // 读取源文件并压缩到zip条目中
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile1), 10240);
                        while (bis.read(bytes) != -1) {
                            zipOutputStream.write(bytes);
                        }
                        bis.close();
                    }
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
