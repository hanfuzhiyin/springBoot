/*
 * @(#)WebConfig.java    Created on 2019年9月4日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.hxyc.config.common.interceptor.IndexInterceptor;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月4日 上午9:47:06 $
 */

@Configuration // 将其变成配置类
public class WebConfig extends WebMvcConfigurationSupport {
    // 需要拦截的路径
    String[] addPathPatterns = { "/index/**", "/admin/**" };
    // 不拦截的路径
    String[] excludePathPatterns = { "/hello", "/login", "/register", "loginOut" };

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IndexInterceptor()).addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/").addResourceLocations("classpath:/public/");
        super.addResourceHandlers(registry);
    }

}
