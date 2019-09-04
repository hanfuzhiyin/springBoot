/*
 * @(#)IndexAdminController.java    Created on 2019年9月4日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月4日 上午10:26:33 $
 */
@Controller
@RequestMapping(value = "/admin")
public class IndexAdminController {

    @RequestMapping("/index")
    public String adminIndex() {
        return "admin/index";
    }
}
