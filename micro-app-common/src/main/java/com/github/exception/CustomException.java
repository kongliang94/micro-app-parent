package com.github.exception;

/**
 * 自定义异常(CustomException)
 * @author dolyw.com
 * @date 2018/8/30 13:59
 */
public class CustomException extends RuntimeException {
    private Integer code;//状态码
    private String msg;//异常信息

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CustomException(String msg){
        super(msg);
    }

    public CustomException() {
        super();
    }
}
