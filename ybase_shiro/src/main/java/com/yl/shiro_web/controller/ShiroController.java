package com.yl.shiro_web.controller;

import com.yl.shiro_web.services.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 杨黎
 * @Title
 * @description
 * @DATE 2018/10/22  20:32
 */
@Controller
public class ShiroController {
    @Autowired
    private ShiroService shiroService;

    @RequestMapping("/gologin")
    public String goLogin() {
        return "/login.jsp";
    }

    @RequestMapping("/login")
    public ModelAndView login(String username, String password) {
        try {
            shiroService.doLogin(username, password);
        } catch (Exception e) {
            return new ModelAndView("/error.jsp", "msg", e.getMessage());
        }
        return new ModelAndView("/index.jsp");
    }
    @RequestMapping("/logout")
    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "/login.jsp";
    }


    /**
     * 模拟不同的请求，在配置文件中对请求进行权限拦截
     */
    @RequestMapping("/do{act}")
    public ModelAndView get(@PathVariable String act) {
        //简化代码，省略数据库操作
        //通过页面上显示的信息查看请求是否被拦截
        return new ModelAndView("/page.jsp", "page", act);
    }

}
