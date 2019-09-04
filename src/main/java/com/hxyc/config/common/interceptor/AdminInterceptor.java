/*
 * @(#)IndexInterceptor.java    Created on 2019年9月4日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.config.common.interceptor;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月4日 上午9:48:46 $
 */
public class AdminInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger("AdminInterceptor");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String reqURL = request.getRequestURL().toString();
        String ip = request.getRemoteHost();
        if (handler instanceof HandlerMethod) {
            StringBuilder sb = new StringBuilder(1000);
            HandlerMethod h = (HandlerMethod) handler;
            // Controller 的包名
            sb.append("\n------------------------------------------------------------\n");
            sb.append("Controller    : ").append(h.getBean().getClass().getName()).append("\n");
            // 方法名称
            sb.append("Method        : ").append(h.getMethod().getName()).append("\n");
            // 请求方式 post\put\get 等等
            sb.append("RequestMethod : ").append(request.getMethod()).append("\n");
            // 所有的请求参数
            sb.append("Params        : ").append(getParamString(request.getParameterMap())).append("\n");
            // 部分请求链接
            sb.append("URI           : ").append(request.getRequestURI()).append("\n");
            // 完整的请求链接
            sb.append("AllURI        : ").append(reqURL).append("\n");
            // 请求方的 ip地址
            sb.append("request IP    : ").append(ip).append("\n");
            sb.append("------------------------------------------------------------\n");
            logger.info(sb.toString());
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

    private String getParamString(Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        for (Entry<String, String[]> e : map.entrySet()) {
            sb.append(e.getKey()).append("=");
            String[] value = e.getValue();
            if (value != null && value.length == 1) {
                sb.append(value[0]).append("\t");
            }
            else {
                sb.append(Arrays.toString(value)).append("\t");
            }
        }
        return sb.toString();
    }
}
