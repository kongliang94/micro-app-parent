package com.github.order.controller;

import com.github.common.model.ResultModel;
import com.github.order.service.OrderService;
import com.github.order.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class OrderController {


    @Autowired
    private TestService testService;


    @Autowired
    private OrderService orderService;

    @GetMapping(value ="/order/{id}")
    public ResultModel getOrderById(@PathVariable("id") Long id){
        return orderService.getOrderById(id);
    }
}
