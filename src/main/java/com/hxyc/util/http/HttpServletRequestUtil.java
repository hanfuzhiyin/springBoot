/*
 * @(#)HttpServletRequestUtil.java    Created on 2019年9月5日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.util.http;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月5日 下午2:32:43 $
 */
public class HttpServletRequestUtil {

    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request;
    }
}
