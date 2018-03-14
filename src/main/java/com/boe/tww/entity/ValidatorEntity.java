package com.boe.tww.entity;

import com.boe.tww.validator.FlagValidator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;


/**
 * 验证实体类
 *
 * @author 唐万万
 * @create 2018-03-14 15:25
 */
public class ValidatorEntity {
    @NotBlank
    @Length(min=2,max=10)
    private String name;

    @Min(value=1)
    private int age;

    @NotBlank
    @Email
    private String mail;

    @FlagValidator(values="1,2,3")
    private String flag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
