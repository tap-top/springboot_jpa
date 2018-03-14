package com.boe.tww.mail;

import com.boe.tww.mail.core.MailSender;
import com.boe.tww.mail.enums.MailContentTypeEnum;

import java.util.ArrayList;

/**
 * 测试邮箱
 *
 * @author 唐万万
 * @create 2018-03-13 16:33
 */
public class TestMail {
    public static void main(String[] args) throws Exception
    {
        new MailSender()
                .title("测试SpringBoot发送邮件")
                .content("简单文本内容发送")
                .contentType(MailContentTypeEnum.TEXT)
                .targets(new ArrayList<String>(){{
                    add("1451548858@qq.com");
                }})
                .send();
    }
}
