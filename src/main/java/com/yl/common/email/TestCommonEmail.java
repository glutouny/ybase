package com.yl.common.email;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * @author 杨黎
 * @Title   TestCommonEmail
 * @description 测试普通邮件发送
 * @DATE 2018/9/25  13:54
 */
public class TestCommonEmail {

    public TestCommonEmail() {
    }

    public static void main(String[] args) {
        SimpleEmail email = new SimpleEmail();
        //设置使用发电子邮件的邮件服务器（这里以qq邮箱为例）
        email.setHostName("smtp.qq.com");
        try{
            //收件人邮箱
            email.addTo("786324994@qq.com");
            //邮箱服务器身份验证
            email.setAuthentication("1102962560@qq.com","bxkihwasgafbjhaa");
            //发件人邮箱
            email.setFrom("1102962560@qq.com");
            //邮件主题
            email.setSubject("电子竞技");
            //邮件内容
            email.setMsg("骚年，high起来啊");
            //发送邮件
            email.send();
        }catch (EmailException e){
            e.printStackTrace();
        }
    }
}
