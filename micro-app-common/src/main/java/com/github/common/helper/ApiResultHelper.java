package com.github.common.helper;


import com.github.common.model.ApiResultModel;

/**
 * 接口结果返回封装帮助工具类
 *
 * <p>
 *     该工具类操作的实体类是：{@link ApiResultModel}
 * </p>
 *
 * <p>
 *     我们提供了如下三个方法：
 * </p>
 *
 * <ul>
 *     <li>success(S code, String message, T data)：成功，并返回的数据的方法</li>
 *     <li>success(S code, String message)：成功，不返回数据</li>
 *     <li>error(S code, String message)：失败</li>
 * </ul>
 *
 * @author Erwin Feng
 * @since 2019-08-21 10:47
 */
public class ApiResultHelper {

    /**
     * 成功，携带返回码和描述信息
     * @param code 返回码
     * @param message 描述信息
     * @param <S> 返回码类型
     * @param <T> 数据类型
     * @return 返回结果封装 {@link ApiResultModel}
     */
    public static <S, T> ApiResultModel<S, T> success(S code, String message) {
        return new ApiResultModel<>(code, message, null);
    }

    /**
     * 成功，携带返回码、描述信息和数据
     * @param code 返回码
     * @param message 描述信息
     * @param data 数据
     * @param <S> 返回码类型
     * @param <T> 数据类型
     * @return 返回结果封装 {@link ApiResultModel}
     */
    public static <S, T> ApiResultModel<S, T> success(S code, String message, T data) {
        return new ApiResultModel<>(code, message, data);
    }

    /**
     * 错误，携带错误码和详细描述信息
     * @param code 返回码
     * @param message 描述信息
     * @param <S> 返回码类型
     * @param <T> 数据类型
     * @return 返回结果封装 {@link ApiResultModel}
     */
    public static <S, T> ApiResultModel<S, T> error(S code, String message) {
        return new ApiResultModel<>(code, message);
    }

}
