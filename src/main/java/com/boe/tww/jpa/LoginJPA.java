package com.boe.tww.jpa;

import com.boe.tww.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 唐万万
 * @create 2018-03-15 15:36
 */
public interface LoginJPA extends JpaRepository<LoginEntity, Long> {
    public LoginEntity findByUsername(String username);
}
