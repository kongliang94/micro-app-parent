package com.github.order.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.common.model.ResultModel;
import com.github.order.entity.Order;
import com.github.order.entity.PayLog;
import com.github.order.mapper.OrderMapper;
import com.github.order.mapper.PayLogMapper;
import com.github.utils.ResultUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/edu_order/pay_log")
public class PayLogController {

    private OrderMapper orderMapper;
    private PayLogMapper payLogMapper;

    public PayLogController(OrderMapper orderMapper, PayLogMapper payLogMapper) {
        this.orderMapper = orderMapper;
        this.payLogMapper = payLogMapper;
    }

    @RequestMapping("/{id}")
    public ResultModel getById(@PathVariable String id){
        PayLog payLog=payLogMapper.selectById(id);
        return ResultUtils.success(payLog);
    }
    @GetMapping("")
    public ResultModel getAll(Page page,PayLog payLog){

        return ResultUtils.success(payLogMapper.selectPage(page, Wrappers.query(payLog)));
    }

    @PutMapping("")
    public void update(@RequestBody Map<String,String> map){
        //从map获取订单号
        String orderNo = map.get("out_trade_no");
        //根据订单号查询订单信息
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no",orderNo);
        Order order = orderMapper.selectOne(wrapper);

        //更新订单表订单状态
        if(order.getStatus().intValue() == 1) { return ; }
        order.setStatus(1);//1代表已经支付
        orderMapper.updateById(order);

        //向支付表添加支付记录
        PayLog payLog = new PayLog();
        payLog.setOrderNo(orderNo);  //订单号
        payLog.setPayTime(new Date()); //订单完成时间
        payLog.setPayType(1);//支付类型 1微信
        payLog.setTotalFee(order.getTotalFee());//总金额(分)

        payLog.setTradeState(map.get("trade_state"));//支付状态
        payLog.setTransactionId(map.get("transaction_id")); //流水号
        payLog.setAttr(JSONObject.toJSONString(map));

        payLogMapper.insert(payLog);
    }
}

