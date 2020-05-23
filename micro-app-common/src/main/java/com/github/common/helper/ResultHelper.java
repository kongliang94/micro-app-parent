package com.github.common.helper;


import com.github.common.model.ResultModel;

/**
 * 结果返回封装帮助工具类
 *
 * <p>
 *     该工具类操作的实体类是：{@link ResultModel}
 * </p>
 *
 * <p>
 *     我们提供了如下三个方法：
 * </p>
 *
 * <ul>
 *     <li>success(String message, T data)：成功，并返回的数据的方法</li>
 *     <li>success(String message)：成功，不返回数据</li>
 *     <li>error(String message)：失败</li>
 * </ul>
 *
 * @author Erwin Feng
 * @since 2019-08-02 18:14
 */
public class ResultHelper {

    /**
     * 成功，携带描述信息
     * @param message 描述信息
     * @param <T> 数据类型
     * @return 返回结果封装 {@link ResultModel}
     */
    public static <T> ResultModel<T> success(String message) {
        return new ResultModel<>(message, null);
    }

    /**
     * 成功，携带描述信息和数据
     * @param message 描述信息
     * @param data 数据
     * @param <T> 数据类型
     * @return 返回结果封装 {@link ResultModel}
     */
    public static <T> ResultModel<T> success(String message, T data) {
        return new ResultModel<>(message, data);
    }

    /**
     * 错误，携带详细的描述信息
     * @param message 描述信息
     * @param <T> 数据类型
     * @return 返回结果封装 {@link ResultModel}
     */
    public static <T> ResultModel<T> error(String message) {
        return new ResultModel<>(message);
    }

}
