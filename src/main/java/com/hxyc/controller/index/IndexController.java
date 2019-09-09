/*
 * @(#)IndexController.java    Created on 2019年9月3日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.controller.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxyc.config.common.constant.BaseConstant;
import com.hxyc.entity.User;
import com.hxyc.service.RedisService;
import com.hxyc.service.index.IndexService;

/**
 * @author user
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 下午3:20:44 $
 */
@Controller
@RequestMapping(value = "/home")
public class IndexController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/index")
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "sendMessage")
    @ResponseBody
    public String sendMessage(String msg) {
        redisService.sendMessage(BaseConstant.REDIS_MESSAGE_KEY, msg);
        return "";
    }

    @RequestMapping(value = "setUserQueue")
    @ResponseBody
    public String setUserQueue() {
        User user = null;
        for (int i = 1; i < 21; i++) {
            user = new User();
            user.setUserName("test" + i);
            user.setId(i + 0L);
            user.setPassWord("pwd" + i);
            redisService.leftPush("waitSaveUser", user);
        }
        return "";
    }

    @RequestMapping(value = "getUserQueue")
    @ResponseBody
    public String getUserQueue(User user, boolean flag) {
        redisService.rightPopAndLeftPush("waitSaveUser", "saveUser");
        if (flag) {// 模拟保存成功,减去保存用户缓存中的一个值
            User user1 = (User) redisService.rightPop("saveUser");
            System.out.println("保存成功" + user1.toString());
            redisService.rightPop("saveUser");
        }
        else {
            User user1 = (User) redisService.rightPop("saveUser");
            System.out.println("保存失败" + user1.toString());
            redisService.sendMessage(BaseConstant.REDIS_MESSAGE_KEY, "保存失败" + user1.toString());
            redisService.leftPush("waitSaveUser", user1);

        }
        // User nUser = (User) redisService.rightPop("waitSaveUser");
        return "";// nUser.toString();
    }
}
