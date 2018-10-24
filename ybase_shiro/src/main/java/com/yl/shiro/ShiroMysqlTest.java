package com.yl.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 杨黎
 * @Title
 * @description
 * @DATE 2018/10/22  15:56
 */
public class ShiroMysqlTest {

    private static final transient Logger LOGGER = LoggerFactory.getLogger(ShiroMysqlTest.class);

    public static void main(String[] args) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-mysql.ini");
        SecurityManager securityManager =  factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("test","123456");
        token.setRememberMe(Boolean.TRUE);//是否记住用户

        try {
            subject.login(token);
            LOGGER.info("用户["+subject.getPrincipal()+"]登陆成功");
            //查看用户是否有admin角色
            if(subject.hasRole("admin")){
                LOGGER.info("你有admin");
            }else{
                LOGGER.info("你没有admin");
            }
            if(subject.hasRole("testadmin")){
                LOGGER.info("你有testadmin");
            }else{
                LOGGER.info("你没有testadmin");
            }
            // 查看用户是否有某个权限
            if(subject.isPermitted("test")){
                LOGGER.info("你有test权限");
            }else{
                LOGGER.info("你没有test权限");
            }
            if(subject.isPermitted("guest")){
                LOGGER.info("你有guest权限");
            }else{
                LOGGER.info("你没有有guest权限");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

    }
}
