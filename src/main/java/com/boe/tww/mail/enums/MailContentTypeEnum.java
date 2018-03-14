package com.boe.tww.mail.enums;

/**
 * 枚举类型
 *
 * @author 唐万万
 * @create 2018-03-13 16:38
 */
public enum MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"),
    TEXT("text");
    private String value;

    MailContentTypeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
