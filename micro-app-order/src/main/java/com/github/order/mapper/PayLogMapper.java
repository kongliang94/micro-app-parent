package com.github.order.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.order.entity.PayLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 支付日志表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-03-13
 */
@Mapper
public interface PayLogMapper extends BaseMapper<PayLog> {

}
