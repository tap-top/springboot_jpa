package com.boe.tww.service;

import com.boe.tww.entity.LoginEntity;
import com.boe.tww.jpa.LoginJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author 唐万万
 * @create 2018-03-15 15:38
 */
public class LoginService implements UserDetailsService {
    @Autowired
    LoginJPA loginJPA;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LoginEntity loginEntity = loginJPA.findByUsername(s);
        if (loginEntity == null) {
            throw new UsernameNotFoundException("未查到用户：" + s + "信息");
        }
        return loginEntity;
    }
}
