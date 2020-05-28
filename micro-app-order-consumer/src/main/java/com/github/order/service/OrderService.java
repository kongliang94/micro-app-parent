package com.github.order.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.order.entity.Order;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-03-13
 */
public interface OrderService{

    //1 生成订单的方法
    String createOrders(String courseId, String memberIdByJwtToken);

    boolean getOrderStatus(String courseId, String memberId, Integer payType);

    Order getByOrderNo(String orderNo);
}
