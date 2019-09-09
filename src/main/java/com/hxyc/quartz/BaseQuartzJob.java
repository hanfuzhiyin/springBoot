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
        redisService.sendMessage(BaseConstant.REDIS_MESSAGE_KEY, "开始处理保存用户!");
        List<Object> userList = redisService.lGet("waitSaveUser", 0, 10);
        int i = 0;
        for (Object object : userList) {
            User user = (User) object;
            if (i == 5) {// 模拟保存失败
                redisService.leftPush("errUser", user);
            }
            System.err.println(user.getUserName());
            i++;
        }
        redisService.removeRange("waitSaveUser", 0, 10);
    }
}
