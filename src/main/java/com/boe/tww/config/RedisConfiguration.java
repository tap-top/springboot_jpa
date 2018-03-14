package com.boe.tww.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * redis配置
 *
 * @author 唐万万
 * @create 2018-03-14 16:09
 */
@Configuration
@EnableCaching
public class RedisConfiguration {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisConfiguration(StringRedisTemplate template) {
        this.stringRedisTemplate = template;
    }
}

