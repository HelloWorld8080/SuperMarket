package com.sm.web;

import com.sm.Component.EmailSender;
import com.sm.entity.User;
import com.sm.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.util.Arrays;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/{path}")
    public String login(@PathVariable("path") String path) {
        return path;
    }

    @RequestMapping("/valid")
    public String valid(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassWord());

        try {
            subject.login(token);
            return "redirect:/comm/list?id=1";
        } catch (Exception e) {
            return "login";
        }
//        User user1 = userService.selectByUserName(user.getUserName());
//        System.out.println(user1);
//
//        return user1 == null ? "no" : "yes";
    }

    @RequestMapping("/register")
    public String register(User user) throws MessagingException {
        System.out.println(user.getPassWord());
        userService.insertSelective(user);
        EmailSender.sendTemplate("justinniu@yeah.net", new String[]{user.getEmail()}, "欢迎注册", user.getUserName());
        return "redirect:/login/login";
    }
}
