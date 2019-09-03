/*
 * @(#)IndexLoginService.java    Created on 2019年9月3日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hzy.service.index.login;

import com.hzy.entity.User;

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
    int registerUser(User user);

}
