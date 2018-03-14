package com.boe.tww.entity;

import com.boe.tww.base.BaseEntity;

import javax.persistence.*;

/**
 * @author 唐万万
 * @create 2018-03-13 10:24
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity{
    @Id
    @Column(name = "t_id")
    private Long id;
    @Basic
    @Column(name = "t_name")
    private String name;
    @Basic
    @Column(name = "t_age")
    private Integer age;
    @Basic
    @Column(name = "t_address")
    private String address;
    @Basic
    @Column(name = "t_password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
