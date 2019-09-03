package com.hxyc.util.common;

import org.apache.commons.lang3.StringUtils;

/**
 * @auther hzy
 * @data 2018/4/28 18:10
 * @see 1.result = Result.success(dataMap);// 成功，并返回数据和code和message<br>
 *      2.result = Result.success();// 成功，不返回数据，只返回code和message<br>
 *      3.result = Result.error(CodeMsg.SERVER_EXCEPTION);//失败返回错误信息<br>
 *      4.result = Result.error(CodeMsg.SERVER_EXCEPTION,e.toString());// 失败返回错误+扩展错误信息
 */

public class Result<T> {
    private String message;
    private int code;
    private boolean success;
    private T data;

    private Result(T data, String msg) {
        this.code = 200;
        String str = msg;
        if (StringUtils.isNotBlank(msg)) {
            str = "-" + msg;
        }
        this.message = "操作成功" + str;
        this.data = data;
        this.success = true;
    }

    private Result(CodeMsg cm, String msg) {
        if (cm == null) {
            return;
        }
        this.code = cm.getCode();
        String str = msg;
        if (StringUtils.isNotBlank(msg)) {
            str = "-" + msg;
        }
        this.message = cm.getMessage() + str;
        this.success = cm.getSuccess();
    }

    /**
     * 成功时候的调用
     *
     * @param data
     *            数据类型
     * @param msg
     *            扩展成功消息
     * @return
     */
    public static <T> Result<T> success(T data, String msg) {
        return new Result<T>(data, msg);
    }

    /**
     * 成功时候的调用
     *
     * @param data
     *            数据类型
     * @return
     */
    public static <T> Result<T> success(T data) {
        return success(data, "");
    }

    /**
     * 成功，不需要传入参数
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Result<T> success() {
        return (Result<T>) success("", "");
    }

    /**
     * 失败时候的调用
     *
     * @return
     */
    public static <T> Result<T> error(CodeMsg cm) {
        return new Result<T>(cm, "");
    }

    /**
     * 失败时候的调用,扩展消息参数
     *
     * @param cm
     * @param msg
     * @return
     */
    public static <T> Result<T> error(CodeMsg cm, String msg) {
        return new Result<T>(cm, msg);
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public boolean getSuccess() {
        return success;
    }

}
