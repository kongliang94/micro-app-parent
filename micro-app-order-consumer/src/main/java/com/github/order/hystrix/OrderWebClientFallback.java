package com.github.order.hystrix;

import com.github.common.model.ResultModel;
import com.github.order.client.OrderWebClient;
import com.github.order.entity.Order;
import com.github.utils.ResultUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: 熔断器
 * @author: KL
 * @create: 2020-05-30
 */
@Component
public class OrderWebClientFallback implements OrderWebClient {
    @Override
    public ResultModel getOrderById(String id) {
        Order order=new Order();
        order.setOrderNo("1000001");
        order.setCourseId("1000001");
        return ResultUtils.success(order);
    }

    @Override
    public ResultModel saveOrder(Order order) {
        return null;
    }

    @Override
    public int selectCount() {
        return 0;
    }

    @Override
    public Order getOrderByOrderNo(String orderNo) {
        return null;
    }

    @Override
    public void updateOrdersStatus(Map<String, String> map) {

    }
}
