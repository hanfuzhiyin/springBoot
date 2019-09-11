/*
 * @(#)UserOpenController.java    Created on 2019年9月11日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户激活
 *
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月11日 下午12:02:33 $
 */
@RequestMapping("/open/service/")
@Controller
public class UserOpenController extends BaseController {

    @RequestMapping(value = "activationUser")
    public String activationUser(String uCode, String salt, ModelMap map) {
        System.out.println(uCode);
        System.out.println(salt);
        map.put("userName", uCode);
        return "/index/activationUserEnd";
    }
}
