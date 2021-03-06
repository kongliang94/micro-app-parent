package com.github.exception;



import com.github.common.model.ResultModel;
import com.github.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public ResultModel error(Exception e) {
        e.printStackTrace();
        log.error("====服务出现异常[{}]===",e.getMessage());
        return ResultUtils.error(500,"执行了全局异常处理..");
    }

    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody //为了返回数据
    public ResultModel error(ArithmeticException e) {
        e.printStackTrace();
        return ResultUtils.error(500,"执行了ArithmeticException异常处理..");
    }

    //自定义异常
    @ExceptionHandler(CustomException.class)
    @ResponseBody //为了返回数据
    public ResultModel error(CustomException e) {
        log.error(e.getMessage());
        e.printStackTrace();

        return ResultUtils.error(e.getCode(),e.getMsg());
    }

}
