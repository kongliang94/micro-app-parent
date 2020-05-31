package com.github.order.client;

import com.github.common.model.ResultModel;
import com.github.order.entity.Order;
import com.github.order.hystrix.OrderWebClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Component
@FeignClient(value = "order-service-provider",fallback = OrderWebClientFallback.class)
public interface OrderWebClient {

    @GetMapping(value ="/orders/{id}")
    ResultModel getOrderById(@PathVariable("id") String id);

    @PostMapping(value ="/orders")
    ResultModel saveOrder(@RequestBody Order order);

    @GetMapping(value ="/orders/count")
    int selectCount();

    @GetMapping(value ="/orders/no/{orderNo}")
    Order getOrderByOrderNo(@PathVariable("orderNo") String orderNo);

    @PutMapping("/edu_order/pay_log")
    void updateOrdersStatus(@RequestBody Map<String, String> map);
}
