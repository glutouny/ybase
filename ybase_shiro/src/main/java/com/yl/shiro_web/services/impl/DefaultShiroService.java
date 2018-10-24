package com.yl.shiro_web.services.impl;

import com.yl.shiro_web.daos.ShiroDao;
import com.yl.shiro_web.services.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨黎
 * @Title
 * @description
 * @DATE 2018/10/22  20:25
 */
public class DefaultShiroService implements ShiroService{

    @Resource
    private ShiroDao shiroDao;

    @Override
    public void doLogin(String username, String password) throws Exception {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token =
                    new UsernamePasswordToken(username, password);
            token.setRememberMe(true);//是否记住用户 rememberMe后浏览器里会生成一个cookie：
            try {
                currentUser.login(token);//执行登录
            } catch (UnknownAccountException uae) {
                throw new Exception("账户不存在");
            } catch (IncorrectCredentialsException ice) {
                throw new Exception("密码不正确");
            } catch (LockedAccountException lae) {
                throw new Exception("用户被锁定了 ");
            } catch (AuthenticationException ae) {
                ae.printStackTrace();
                throw new Exception("未知错误");
            }
        }
    }

    @Override
    public String getPasswordByUserName(String username) {
        return shiroDao.getPasswordByUserName(username);
    }

    @Override
    public List<String> getPermissionByUserName(String username) {
        return shiroDao.getPermissionByUserName(username);
    }
}
