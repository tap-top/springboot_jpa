package com.boe.tww.config;

import com.boe.tww.servlet.TestServlet;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * servlet配置文件
 *
 * @author 唐万万
 * @create 2018-03-14 10:11
 */
@Configuration
@ServletComponentScan("com.boe.tww.servlet")
public class ServletConfiguration {
    //@Bean
    //public ServletRegistrationBean servletRegistrationBean(){
    //    return new ServletRegistrationBean(new TestServlet(), "/test");
    //}
}
