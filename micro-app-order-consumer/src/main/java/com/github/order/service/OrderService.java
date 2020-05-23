package com.github.order.service;

import com.github.common.model.ResultModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "order-service-provider")
public interface OrderService {

    @GetMapping(value ="/order/{id}")
    public ResultModel getOrderById(@PathVariable("id") Long id);
}
