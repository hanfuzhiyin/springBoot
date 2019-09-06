/*
 * @(#)CacheCall.java    Created on 2019年9月6日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.config.common.redis;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月6日 下午1:54:33 $
 */
public interface RedisCall {

    public interface RedisKey {
        /**
         * 获取key
         *
         * @return
         */
        public String fetchKey();

        /**
         * 数据类型
         *
         * @return
         */
        public String getDataType();
    }

    /**
     * 缓存对象参数
     */
    public interface RedisObjectParam<V> extends RedisKey {
        /**
         * 获取对象
         *
         * @return
         */
        public V fetchObject();
    }
}
