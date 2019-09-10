/*
 * @(#)BaseQuartz.java    Created on 2019年9月9日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.quartz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hxyc.config.common.constant.BaseConstant;
import com.hxyc.entity.User;
import com.hxyc.service.RedisService;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月9日 下午6:53:33 $
 */

@Component
public class BaseQuartzJob {

    @Autowired
    private RedisService<?> redisService;

    @Scheduled(cron = "0/3 * * * * ? ") // cron表达式
    public void saveUserTask() {
        List<User> userList = (List<User>) redisService.rightPop("waitSaveUser");
        if (null == userList) {
            return;
        }
        int i = 0;
        for (User user : userList) {
            if (i == 5) {// 模拟保存失败
                redisService.leftPush("errUser", user);
                redisService.sendMessage(BaseConstant.REDIS_MESSAGE_KEY, "用户[" + user.getUserName() + "]保存失败!");
            }
            i++;
        }
    }
}
