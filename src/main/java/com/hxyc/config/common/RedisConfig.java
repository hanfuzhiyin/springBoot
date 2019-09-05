/*
 * @(#)RedisConfig.java    Created on 2019年9月5日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.config.common;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月5日 下午2:05:43 $
 */
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.password}")
    private String password;

    /*********************************************************************************/
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
