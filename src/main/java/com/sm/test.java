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
        String subject = "Test";
        StringBuilder htmlContent = new StringBuilder()
                .append("<html>")
                .append("<head>")
                .append("<title>")
                .append("TEST")
                .append("</title>")
                .append("</head>")
                .append("<body>")
                .append("Hi, There<p/>")
                .append("</body>")
                .append("</html>");
        //StringBuilder htmlContent = new StringBuilder("hh").append("<html>").append("<p>").append("没办法").append("</p>").append("</html>");
      //  EmailSender.sendHtmlMessage(sendFrom, sendTo, subject, htmlContent.toString());
        EmailSender.sendTemplate(sendFrom, sendTo, subject, "吴彦祖");
        System.out.println("邮件发送成功.");
    }
}