/*
 * @(#)IndexLoginService.java    Created on 2019年9月3日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.service.index.login;

import com.hxyc.entity.User;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 下午3:55:44 $
 */
public interface IndexLoginService {

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    Integer registerUser(User user);

    /**
     * 通过用户名查询用户
     *
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 通过邮箱查询
     *
     * @param email
     * @return
     */
    User getUserByUserEmail(String email);

}
