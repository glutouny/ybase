package com.yl.common.email;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * @author 杨黎
 * @Title   TestHtmlEmail
 * @description 测试html邮件发送
 * @DATE 2018/9/25  14:23
 */
public class TestHtmlEmail {
    public TestHtmlEmail() {

    }

    public static void main(String[] args) {
        HtmlEmail email = new HtmlEmail();

        try {
            //设置使用发电子邮件的邮件服务器
            email.setHostName("smtp.qq.com");
            //字符编码集设置
            email.setCharset("utf-8");
            //收件人邮箱
            email.addTo("yangli0621ml@163.com");
            //发件人邮箱
            email.setFrom("1102962560@qq.com");
            //邮箱服务器身份验证
            email.setAuthentication("1102962560@qq.com","bxkihwasgafbjhaa");
            //邮件主题
            email.setSubject("电子竞技");
            //邮件内容
            email.setMsg("<h1 style='color:red'>电子竞技活动即将开启</h1>" + "请准时参加！");
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
