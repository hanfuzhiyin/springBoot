/*
 * @(#)UserMapper.java    Created on 2019年9月3日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.mapper.user;

import org.springframework.stereotype.Repository;

import com.hxyc.entity.User;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 下午5:38:51 $
 */
@Repository
public interface UserMapper {

    Integer registerUser(User user);

    User getUserByUserName(String userName);

    User getUserByUserEmail(String email);
}
