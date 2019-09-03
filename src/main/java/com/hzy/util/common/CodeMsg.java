package com.hzy.util.common;

/**
 * @auther hzy
 * @data 2018/4/28 18:06
 */

public class CodeMsg {
    private int code;
    private String message;
    private boolean success;
    // 按照模块定义CodeMsg
    // 通用异常
    public static CodeMsg SUCCESS = new CodeMsg(200, "success", true);
    public static CodeMsg SERVER_EXCEPTION = new CodeMsg(500, "系统异常", false);
    public static CodeMsg PARAMETER_ISNULL = new CodeMsg(0, "学校参数错误", false);

    public static CodeMsg NOT_FIND_DATA = new CodeMsg(1, "数据为空", true);
    public static CodeMsg DEFEAT = new CodeMsg(2, "操作失败", true);

    private CodeMsg(int code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
