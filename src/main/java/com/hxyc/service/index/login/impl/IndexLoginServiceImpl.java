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
import com.hxyc.util.common.RSAEncrypt;
import com.hxyc.util.common.UUIDUtil;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 下午3:56:03 $
 */
@Service(value = "indexLoginService")
public class IndexLoginServiceImpl extends RedisService<Object> implements IndexLoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer registerUser(User user) {
        try {
            user.setPublickey(RSAEncrypt.genKeyPair().get(0));
            user.setPrivatekey(RSAEncrypt.genKeyPair().get(1));
            user.setPassWord(RSAEncrypt.encrypt(user.getPassWord(), RSAEncrypt.genKeyPair().get(0)));
            user.setSalt(UUIDUtil.newUUID(32));
            leftPush("userEmail", user);
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return userMapper.registerUser(user);
    }

    @Override
    public User getUserByUserName(String userName) {
        if (hasKey(userName)) {
            User user = (User) get(userName);
            if (null != (user)) {
                return user;
            }
        }
        User user = userMapper.getUserByUserName(userName);
        if (null != user) {
            set(userName, user);
        }
        return user;
    }
}
