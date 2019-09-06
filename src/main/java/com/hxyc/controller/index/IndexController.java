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
import com.hxyc.service.RedisService;

/**
 * @author user
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 下午3:20:44 $
 */
@Controller
@RequestMapping(value = "/home")
public class IndexController {

    @Autowired
    private RedisService redisService;

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
}
