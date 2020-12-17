package com.hhb.show.result;

public class ResultFactory {

    /**
     * 成功
     * @param data
     * @return
     */
    public static Result buildSuccessResult(Object data) {
        return buildResult(ResultCode.SUCCESS, "成功", data);
    }

    /**
     * 失败
     * @param message
     * @return
     */
    public static Result buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, null);
    }

    /**
     * 返回状态码和信息
     * @param resultCode
     * @param message
     * @param data
     * @return
     */
    public static Result buildResult(ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.code, message, data);
    }

    /**
     * 返回结果和信息
     * @param resultCode
     * @param message
     * @param data
     * @return
     */
    public static Result buildResult(int resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }
}