/*
 * @(#)IndexLoginServiceImpl.java    Created on 2019年9月3日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.service.index.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxyc.entity.User;
import com.hxyc.mapper.user.UserMapper;
import com.hxyc.service.RedisService;
import com.hxyc.service.index.login.IndexLoginService;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 下午3:56:03 $
 */
@Service(value = "indexLoginService")
public class IndexLoginServiceImpl extends RedisService implements IndexLoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer registerUser(User user) {
        return userMapper.registerUser(user);
    }

    @Override
    public User getUserByUserName(String userName) {
        if (hasKey(userName)) {
            Object object = get(userName);
            System.out.println(object);
            User user = (User) get(userName);
            if (null != (user)) {
                System.out.println("缓存返回**********************");
                return user;
            }
        }
        User user = userMapper.getUserByUserName(userName);
        set(userName, user);
        System.out.println("数据库返回**********************");
        return user;
    }
}
