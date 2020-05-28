package com.github.order.handler;

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
        var saved = this.orderMapper.insert(data);
        return created(URI.create("/orders/" + data.getId())).build();
    }

    public ServerResponse get(ServerRequest req) {

        return ok().body(ResultUtils.success(this.orderMapper.selectById(Long.valueOf(req.pathVariable("id")))));
    }

    public ServerResponse update(ServerRequest req) throws ServletException, IOException {
        var data = req.body(Order.class);

      /*  return this.orderMapper.selectById(Long.valueOf(req.pathVariable("id")))
                .map(
                        post -> {
                            post.setTitle(data.getTitle());
                            post.setContent(data.getContent());
                            return post;
                        }
                )
                .map(post -> this.posts.save(post))
                .map(post -> noContent().build())
                .orElse(notFound().build());*/

      return ok().body(null);
    }

    public ServerResponse delete(ServerRequest req) {
        return ok().body(this.orderMapper.deleteById(Long.valueOf(req.pathVariable("id"))));
    }

    public ServerResponse selectCount(ServerRequest req){

//        String courseId=req.pathVariable("courseId");
//        String memberId=req.pathVariable("courseId");
//        Integer payType=Integer.valueOf(req.pathVariable("payType"));

        return ok().body(1);
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

        return ok().body(true);
    }

}
