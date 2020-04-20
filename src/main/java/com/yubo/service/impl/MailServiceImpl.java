package com.yubo.service.impl;

import com.yubo.service.MailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/13 9:54
 */
@Service
public class MailServiceImpl implements MailService {
    @Resource
    private Configuration freeMarkerConfiguration;
    @Resource
    private JavaMailSender mailSender;

    @Override
    public boolean sendMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
        helper.setTo("yubo@tianxingshuke.com");
        helper.setFrom("17635109089@163.com");
//        helper.setCc("yubo@tianxingshuke.com");
        helper.setSubject("来自余波的文档");
        // 抄送人是数组
//        helper.setBcc();
        Template template = freeMarkerConfiguration.getTemplate("send_mail.ftl");
        Map<String, Object> modal = new HashMap<>();
        modal.put("date", new Date());
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, modal);
        helper.setText(text, true);
        mailSender.send(mimeMessage);
        return false;
    }
}
