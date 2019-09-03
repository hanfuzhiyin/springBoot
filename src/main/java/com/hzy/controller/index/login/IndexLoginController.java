/*
 * @(#)IndexLoginController.java    Created on 2019年9月3日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hzy.controller.index.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzy.entity.User;
import com.hzy.service.index.login.IndexLoginService;
import com.hzy.util.common.CodeMsg;
import com.hzy.util.common.Result;

/**
 * @author user
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 下午3:27:09 $
 *
 */
@Controller
public class IndexLoginController {

    @Autowired
    private IndexLoginService indexLoginService;

    @RequestMapping(value = "registerUser")
    @ResponseBody
    public Result<String> registerUser(User user) {
        int data = indexLoginService.registerUser(user);
        if (data > 0) {
            return Result.success();
        }
        else {
            return Result.error(CodeMsg.DEFEAT);
        }
    }
}
