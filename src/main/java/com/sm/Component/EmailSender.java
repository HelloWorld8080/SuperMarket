package com.sm.Component;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.file.FileSystem;
import java.util.HashMap;

/**
 * 基于Spring的JavaMailSender的邮件发送工具类
 * @author simon
 *
 */
@Component
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    private static EmailSender emailSender;



    @PostConstruct
    public void init() {
        emailSender = this;
        emailSender.javaMailSender= this.javaMailSender;
        emailSender.velocityEngine = this.velocityEngine;
    }

    /**
     * 发送简单的文本邮件
     * @param sendTo    收件人组
     * @param subject    主题
     * @param content    文本内容
     */
    public static void sendSimpleMessage(String sendFrom, String[] sendTo, String subject, String textcontent) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(sendFrom);
        mail.setTo(sendTo);
        mail.setSubject(subject);
        mail.setText(textcontent);
        //发送
        emailSender.javaMailSender.send(mail);
    }

    /**
     * 发送HTML内容格式的邮件
     * @param sendFrom
     * @param sendTo      收件人组
     * @param subject      主题
     * @param htmlContent    HTML内容
     * @throws Exception
     */
    public static void sendHtmlMessage(String sendFrom, String[] sendTo, String subject, String htmlContent) throws Exception {
        MimeMessage mimeMessage = emailSender.javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(sendFrom);
        mimeMessageHelper.setTo(sendTo);
        mimeMessageHelper.setSubject(subject);
        // true 表示启动HTML格式的邮件
        mimeMessageHelper.setText(htmlContent, true);
        FileSystemResource resource = new FileSystemResource("C:\\Users\\11291\\AppData\\Local\\Temp\\1531376867069.png");
        mimeMessageHelper.addAttachment("ww", resource);

        // 发送邮件
        emailSender.javaMailSender.send(mimeMessage);
    }

    public static void sendTemplate(String sendFrom, String[] sendTo, String subject, String user) throws MessagingException {
        MimeMessage mimeMessage = emailSender.javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom(sendFrom);
        mimeMessageHelper.setTo(sendTo);
        mimeMessageHelper.setSubject(subject);
        HashMap<String, Object> model = new HashMap<>();
        model.put("username", user);
        String text = VelocityEngineUtils.mergeTemplateIntoString(emailSender.velocityEngine, "template.vm", "UTF-8", model);mimeMessageHelper.setText(text, true);

        // 发送邮件
        emailSender.javaMailSender.send(mimeMessage);
    }

}