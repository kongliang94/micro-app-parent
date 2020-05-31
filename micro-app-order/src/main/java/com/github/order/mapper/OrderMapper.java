package com.github.order.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单 Mapper 接口
 * </p>
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    Optional<Order> selectByOrderNo(@Param("orderNo")String orderNo);

    Optional<Order> findById(@Param("id")String id);


}
