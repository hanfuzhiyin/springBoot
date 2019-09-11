/*
 * @(#)UserEmailJob.java    Created on 2019年9月11日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.quartz;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hxyc.config.properties.HXYC;
import com.hxyc.entity.User;
import com.hxyc.service.RedisService;
import com.hxyc.util.common.Validation;
import com.hxyc.util.http.SendMailUitls;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月11日 下午12:05:03 $
 */
@Component
public class UserEmailJob {

    @Autowired
    private RedisService<?> redisService;
    @Autowired
    private HXYC hxyc;

    @Scheduled(cron = "0/5 * * * * ? ") // cron表达式
    public void sendUserEmailTask() {
        User user = (User) redisService.rightPop("userEmail");
        if (null == user) {
            return;
        }
        System.out.println(user.toString());
        if (StringUtils.isBlank(user.getEmail())) {
            return;
        }
        if (!Validation.isEmail(user.getEmail())) {
            return;
        }
        try {
            SendMailUitls.sendMail(user.getEmail(), buileHtmlMessage(user.getUserName(), user.getSalt()));
        }
        catch (Exception e) {
            e.printStackTrace();
            redisService.leftPush("userEmailErr", user);
        }

    }

    private String buileHtmlMessage(String uCode, String salt) {
        StringBuffer html = new StringBuffer();
        html.append("<a href='");
        html.append(hxyc.getDomain());
        html.append("/open/service/activationUser?uCode=");
        html.append(uCode);
        html.append("&salt=");
        html.append(salt);
        html.append("'>");
        html.append("点击激活");
        html.append("</a>");
        return html.toString();
    }
}
