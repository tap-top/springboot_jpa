package com.boe.tww.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 唐万万
 * @create 2018-03-15 14:47
 */
@Entity
@Table(name="roles")
public class RoleEntity implements Serializable{
    @Id
    @Column(name="r_id")
    private Long id;
    @Column(name="r_name")
    private String name;
    @Column(name="r_flag")
    private String flag;

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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
