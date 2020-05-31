package com.github.order.handler;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.order.entity.Order;
import com.github.order.mapper.OrderMapper;
import com.github.utils.ResultUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.net.URI;

import static org.springframework.web.servlet.function.ServerResponse.*;

@Component
public class OrderHandler {

    private final OrderMapper orderMapper;

    public OrderHandler(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public ServerResponse all(ServerRequest req) {
        return ok().body(this.orderMapper.selectList(null));
    }

    public ServerResponse create(ServerRequest req) throws ServletException, IOException {

        var data = req.body(Order.class);
        this.orderMapper.insert(data);
        return created(URI.create("/orders/" + data.getId())).build();
    }

    public ServerResponse get(ServerRequest req) {
        return ok().body(ResultUtils.success(this.orderMapper.selectById(Long.valueOf(req.pathVariable("id")))));
    }

    public ServerResponse update(ServerRequest req) throws ServletException, IOException {
        var data = req.body(Order.class);
        return ok().body(orderMapper.updateById(data));
    }

    public ServerResponse delete(ServerRequest req) {
        return ok().body(this.orderMapper.deleteById(Long.valueOf(req.pathVariable("id"))));
    }

    public ServerResponse selectCount(ServerRequest req){
        return ok().body(this.orderMapper.selectCount(null));
    }

    public ServerResponse getByNo(ServerRequest request) {
        return this.orderMapper
                .selectByOrderNo(request.pathVariable("orderNo"))
                .map(post -> ok().body(post))
                .orElse(notFound().build());
    }

    public ServerResponse isBuyCourse(ServerRequest request){

        String courseId=request.pathVariable("courseId");
        String memberId=request.pathVariable("memberId");

        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        wrapper.eq("member_id",memberId);
        wrapper.eq("status",1);//支付状态 1代表已经支付
        int count = orderMapper.selectCount(wrapper);
        if(count>0) { //已经支付
            return ok().body(true);
        } else {
            return ok().body(false);
        }
    }

}
