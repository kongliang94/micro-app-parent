package com.github.utils;


import com.github.common.R;
import com.github.common.ResultCode;
import com.github.common.helper.ApiResultHelper;
import com.github.common.model.ApiResultModel;
import com.github.common.model.ResultModel;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 返回值工具类
 */
public class ResultUtils {

    public static <S, T> ApiResultModel<S, T> success(S code, String message) {
        return ApiResultHelper.success(code, message, null);
    }


    public static <S, T> ApiResultModel<S, T> success(S code, String message, T data) {
        return ApiResultHelper.success(code, message, data);
    }


    public static <S, T> ApiResultModel<S, T> error(S code, String message) {
        return ApiResultHelper.error(code, message);
    }

    public static ResultModel success() {
        return ApiResultHelper.success(200, "success", null);
    }

    public static <S, T> ApiResultModel<S, T> success(T data) {

        if (data==null){
            return (ApiResultModel<S, T>) ApiResultHelper.success(200, "请求数据不存在", data);
        }
        return (ApiResultModel<S, T>) ApiResultHelper.success(200, "success", data);
    }

}
