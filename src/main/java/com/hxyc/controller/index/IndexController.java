/*
 * @(#)IndexController.java    Created on 2019年9月3日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author user
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 下午3:20:44 $
 */
@Controller
public class IndexController {

    @RequestMapping(value = "index")
    public String indexPage() {
        return "index";
    }
}
