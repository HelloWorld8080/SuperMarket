package com.sm;

import com.sm.Component.EmailSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class test {

    @Test
    public void testSend() throws Exception {
        String sendFrom = "justinniu@yeah.net";
        String[] sendTo = {"1129114837@qq.com"};
        String subject = "没办法啊，老师让我回去，还行吧，感觉白代课了，这样我开学就不先回去了";
        StringBuilder htmlContent = new StringBuilder()
                .append("<html>")
                .append("<head>")
                .append("<title>")
                .append("TEST")
                .append("</title>")
                .append("</head>")
                .append("<body>")
                .append("您好!陌生人<p/>")
                .append("</body>")
                .append("</html>");
        //StringBuilder htmlContent = new StringBuilder("hh").append("<html>").append("<p>").append("没办法").append("</p>").append("</html>");
        EmailSender.sendHtmlMessage(sendFrom, sendTo, subject, htmlContent.toString());
        System.out.println("邮件发送成功.");
    }
}