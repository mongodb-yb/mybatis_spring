package com.yubo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/10 15:32
 */
@Controller
@RequestMapping("/file")
public class FileController {


    /**
     * 使用MultipartFile--属于spring-mvc的api
     *
     * @param multipartFile
     */
    @RequestMapping(value = "/upload")
    public void upload1(MultipartFile multipartFile) {
        // 获取原始文件名
        String fileName = multipartFile.getOriginalFilename();
        // 目标文件
        File file = new File(fileName);
        try {
            // 保存文件
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用Part---来自javax.servlet.http.Part;需要到javax的servlet包
     *
     * @param partFile
     */
    @RequestMapping(value = "/upload")
    public void upload2(Part partFile) {
        // 获取原始文件名
        String fileName = partFile.getSubmittedFileName();
        // 目标文件
//        File dest = new File(fileName);
        try {
            // 保存文件
            partFile.write("e:/mvc/" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
