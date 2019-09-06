/*
 * @(#)IndexLoginController.java    Created on 2019年9月3日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.controller.index.login;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxyc.config.common.constant.BaseConstant;
import com.hxyc.controller.base.BaseController;
import com.hxyc.entity.User;
import com.hxyc.service.RedisService;
import com.hxyc.service.index.login.IndexLoginService;
import com.hxyc.util.common.CodeMsg;
import com.hxyc.util.common.RSAEncrypt;
import com.hxyc.util.common.Result;
import com.hxyc.util.common.Validation;
import com.hxyc.util.http.HttpServletRequestUtil;

/**
 * @author user
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 下午3:27:09 $
 *
 */
@Controller
@RequestMapping("/home")
public class IndexLoginController extends BaseController {

    @Autowired
    private IndexLoginService indexLoginService;
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "checkUserName")
    @ResponseBody
    public Result<String> checkUserName(String userName) {
        if (StringUtils.isNotBlank(userName)) {
            if (userName.length() > 10) {
                return errorAndMes("用户名不能超过10位!");
            }
            if (!Validation.checkUserName(userName)) {
                return errorAndMes("用户名规则[首字母+数字字母组成的6-12位]");
            }
            if (redisService.hasKey(userName)) {
                if (StringUtils.isNotBlank(redisService.get(userName).toString())) {
                    return errorAndMes("重复的用户名");
                }
            }
        }
        return success();
    }

    @RequestMapping(value = "/registerUser")
    @ResponseBody
    public Result<String> registerUser(User user) {
        if (redisService.hasKey(user.getUserName())) {
            String oldName = redisService.get(user.getUserName()).toString();
            if (StringUtils.isNotBlank(oldName)) {
                errorAndMes("重复的用户名");
            }
        }
        int data = indexLoginService.registerUser(user);
        if (data > 0) {
            return Result.success();
        }
        else {
            return Result.error(CodeMsg.DEFEAT);
        }
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public Result<String> login(String userName, String passWord, String verification) {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(passWord)) {
            return errorAndMes("请输入用户名和密码!");
        }
        User user = indexLoginService.getUserByUserName(userName);
        if (null == user) {
            return errorAndMes("找不到该用户!");
        }
        try {
            String pwd = RSAEncrypt.decrypt(user.getPassWord(), user.getPrivatekey());
            if (pwd.equals(passWord)) {

                HttpServletRequestUtil.getRequest().getSession().setAttribute(BaseConstant.USER_SESSION, user);
                return Result.success();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return errorAndMes("系统错误!" + e);
        }
        return errorAndMes("用户名或密码不正确!");
    }

    @RequestMapping(value = "/getUser")
    public String getUser(ModelMap map) {
        User user = (User) HttpServletRequestUtil.getRequest().getSession().getAttribute(BaseConstant.USER_SESSION);
        map.put("userName", user.getUserName());
        return "index";
    }
}
