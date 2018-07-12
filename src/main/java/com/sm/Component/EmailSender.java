package com.sm.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;

/**
 * 基于Spring的JavaMailSender的邮件发送工具类
 * @author simon
 *
 */
@Component
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;


    private static EmailSender emailSender;

    @PostConstruct
    public void init() {
        emailSender = this;
        emailSender.javaMailSender= this.javaMailSender;
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

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setFrom(sendFrom);
        mimeMessageHelper.setTo(sendTo);
        mimeMessageHelper.setSubject(subject);
        // true 表示启动HTML格式的邮件
        mimeMessageHelper.setText(htmlContent, true);

        // 发送邮件
        emailSender.javaMailSender.send(mimeMessage);
    }

}