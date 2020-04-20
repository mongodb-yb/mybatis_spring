package com.yubo.test;

import com.yubo.service.MailService;
import com.yubo.service.impl.MailServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yubo
 * @version V1.0
 * @description 发送邮件测试
 * @date 2020/4/13 10:11
 */
public class MailSenderTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        MailServiceImpl mailService = (MailServiceImpl) applicationContext.getBean(MailService.class);
        try {
            mailService.sendMail();
            System.out.println("发送邮件成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发送邮件失败");
        }
    }
}
