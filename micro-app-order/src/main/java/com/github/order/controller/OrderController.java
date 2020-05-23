package com.github.order.controller;

import com.github.common.model.ResultModel;
import com.github.order.entity.Order;
import com.github.utils.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class OrderController {


    @GetMapping("{id}")
    public ResultModel getOrder(@PathVariable Long id){
        Order order=Order.builder().id(id)
                .orderSn("sssss")
                .memberUsername("user"+id)
                .build();

        return ResultUtils.success(order);
    }
}
