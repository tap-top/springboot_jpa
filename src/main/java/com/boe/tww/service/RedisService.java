package com.boe.tww.service;

import com.boe.tww.entity.User;
import com.boe.tww.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 唐万万
 * @create 2018-03-14 16:26
 */
@Service
@CacheConfig(cacheNames = "user")
public class RedisService {
    @Autowired
    private UserJPA userJPA;

    @Cacheable
    public List<User> list(){
        return userJPA.findAll();
    }
}
