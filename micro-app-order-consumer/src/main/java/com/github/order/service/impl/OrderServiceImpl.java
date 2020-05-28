package com.github.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.entity.ordervo.CourseWebVoOrder;
import com.github.entity.ordervo.UcenterMemberOrder;
import com.github.order.client.EduClient;
import com.github.order.client.OrderWebClient;
import com.github.order.client.UcenterClient;
import com.github.order.entity.Order;
import com.github.order.service.OrderService;
import com.github.order.utils.OrderNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-03-13
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private EduClient eduClient;

    @Autowired
    private OrderWebClient orderWebClient;

    @Autowired
    private UcenterClient ucenterClient;

    //1 生成订单的方法
    @Override
    public String createOrders(String courseId, String memberId) {
        //通过远程调用根据用户id获取用户信息
        UcenterMemberOrder userInfoOrder = ucenterClient.getUserInfoOrder(memberId);

        //通过远程调用根据课程id获取课信息
        CourseWebVoOrder courseInfoOrder = eduClient.getCourseInfoOrder(courseId);

        //创建Order对象，向order对象里面设置需要数据
        Order order = new Order();
        order.setOrderNo(OrderNoUtil.getOrderNo());//订单号
        order.setCourseId(courseId); //课程id
        order.setCourseTitle(courseInfoOrder.getTitle());
        order.setCourseCover(courseInfoOrder.getCover());
        order.setTeacherName(courseInfoOrder.getTeacherName());
        order.setTotalFee(courseInfoOrder.getPrice());
        order.setMemberId(memberId);
        order.setMobile(userInfoOrder.getMobile());
        order.setNickname(userInfoOrder.getNickname());
        order.setStatus(0);  //订单状态（0：未支付 1：已支付）
        order.setPayType(1);  //支付类型 ，微信1
        orderWebClient.saveOrder(order);
         //返回订单号
        return order.getOrderNo();
    }

    @Override
    public boolean getOrderStatus(String courseId, String memberId, Integer payType) {


        int count =orderWebClient.selectCount();
        if (count>0){
            return true;
        }
        return false;
    }

    @Override
    public Order getByOrderNo(String orderNo) {
        return orderWebClient.getOrderByOrderNo(orderNo);
    }


}
