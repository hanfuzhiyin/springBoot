/*
 * @(#)UUIDUtil.java    Created on 2019年9月6日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.util.common;

import java.util.UUID;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月6日 上午9:35:04 $
 */
public class UUIDUtil {

    /**
     * 获取新的uuid
     *
     * @param sub
     *            获取多少位的
     * @return
     */
    public static String newUUID(Integer sub) {
        return UUID.randomUUID().toString().replace("-", "").substring(32 - sub);
    }
}
