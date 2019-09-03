/*
 * @(#)IndexLoginServiceImpl.java    Created on 2019年9月3日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hzy.service.index.login.impl;

import org.springframework.stereotype.Service;

import com.hzy.entity.User;
import com.hzy.service.RedisService;
import com.hzy.service.index.login.IndexLoginService;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 下午3:56:03 $
 */
@Service(value = "indexLoginService")
public class IndexLoginServiceImpl extends RedisService implements IndexLoginService {

    @Override
    public int registerUser(User user) {
        boolean set = set("user", user);
        if (set) {
            return 1;
        }
        return 0;
    }
}
