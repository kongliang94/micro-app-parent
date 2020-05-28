package com.github.order.controller;

import com.github.common.model.ResultModel;
import com.github.order.client.OrderWebClient;
import com.github.order.entity.Order;
import com.github.order.service.OrderService;
import com.github.utils.JwtUtils;
import com.github.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/eduorder/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderWebClient orderWebClient;

    //1 生成订单的方法
    @PostMapping("createOrder/{courseId}")
    public ResultModel saveOrder(@PathVariable String courseId, HttpServletRequest request) {
        //创建订单，返回订单号
        String orderNo = orderService.createOrders(courseId, JwtUtils.getMemberIdByJwtToken(request));
        return ResultUtils.success(orderNo);
    }

    //2 根据订单id查询订单信息
    @GetMapping("getOrderInfo/{orderId}")
    public ResultModel getOrderInfo(@PathVariable String orderId) {
        return orderWebClient.getOrderById(orderId);
    }

    //根据课程id和用户id查询订单表中订单状态
    @GetMapping("isBuyCourse/{courseId}/{memberId}")
    public boolean isBuyCourse(@PathVariable String courseId,@PathVariable String memberId) {

        return orderService.getOrderStatus(courseId,memberId,1); //1代表已支付

    }
}
