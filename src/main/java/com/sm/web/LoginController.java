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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Entity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

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
    public String valid(User user, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassWord());

        try {
            subject.login(token);
         //   session.setAttribute("currentUser", user.getUserName());
            return "redirect:/comm/list?id=1";
        } catch (Exception e) {
            return "login";
        }
//        User user1 = userService.selectByUserName(user.getUserName());
//        System.out.println(user1);
//
//        return user1 == null ? "no" : "yes";
    }

    @RequestMapping("/regis")
    public String register(User user, Model model, HttpServletRequest request) throws MessagingException {
//        System.out.println(user);
        if (userService.selectByUserName(user.getUserName()) == null) {
            if (checkEmail(user.getEmail())) {
                request.getSession().setAttribute("userWait", user);
                EmailSender.sendTemplate("justinniu@yeah.net", new String[]{user.getEmail()}, "欢迎注册", user.getUserName());
                model.addAttribute("msg", "前往邮箱完成注册");
                return "register";
            }
            else {
                model.addAttribute("msg", "该邮箱 " + user.getEmail() + " 不正确");
                return "register";
            }

        }
        else {
            model.addAttribute("msg", "该用户 " + user.getUserName() + " 已注册");
            return "register";
        }
    }
    @RequestMapping("/compl")
    public String complete(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("userWait");
        System.out.println(user);
        userService.insertSelective(user);
        return "redirect:/comm/list";

    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("currentUser");
        return "login";
    }
//    验证邮箱的正确行
    public static boolean checkEmail(String email) {
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        HashMap<String, Integer> zwt = new HashMap();
        zwt.put("niu", 18);
        zwt.put("zhang", 17);
        Iterator it = zwt.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println(e.getKey() + " : "+ e.getValue());

        }
        return Pattern.matches(regex, email);
    }

}
