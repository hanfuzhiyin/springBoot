/*
 * @(#)BaseController.java    Created on 2019年9月3日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.controller.base;

import com.hxyc.util.common.CodeMsg;
import com.hxyc.util.common.Result;

/**
 * @author user
 * @version $Revision: 1.0 $, $Date: 2019年9月3日 下午3:21:33 $
 */
public class BaseController {

    /**
     * 返回成功
     *
     * @return
     */
    public Result<String> success() {
        return Result.success();
    }

    /**
     * 返回成功,并返回一个String的返回值
     *
     * @param data
     * @return
     */
    public Result<String> successAndData(String data) {
        return Result.success(data);
    }

    /**
     * 返回成功,并返回一个String的返回值和一个提示语,前缀为操作成功-msg
     *
     * @param data
     * @param msg
     * @return
     */
    public Result<String> successAndDataAndMes(String data, String msg) {
        return Result.success(data, msg);
    }

    /**
     * 返回成功,并返回一个Object的返回值
     *
     * @param data
     * @return
     */
    public Result<Object> successAndData(Object data) {
        return Result.success(data);
    }

    /**
     * 返回成功,并返回一个Object的返回值和一个提示语,前缀为操作成功-msg
     *
     * @param data
     * @param msg
     * @return
     */
    public Result<Object> successAndDataAndMes(Object data, String msg) {
        return Result.success(data, msg);
    }

    /**
     * 直接返回失败
     *
     * @return
     */
    public Result<String> error() {
        return Result.error(CodeMsg.DEFEAT);
    }

    /**
     * 返回失败加自定义语句
     *
     * @param msg
     * @return
     */
    public Result<String> errorAndMes(String msg) {
        return Result.error(CodeMsg.DEFEAT, msg);
    }

    /**
     * 通过返回值直接返回 大于0成功 其他失败
     *
     * @param count
     * @return
     */
    public Result<String> returnResult(Integer count) {
        if (count > 0) {
            return success();
        }
        return error();
    }
}
