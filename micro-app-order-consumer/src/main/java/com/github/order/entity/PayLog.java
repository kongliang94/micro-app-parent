package com.github.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 支付日志表
 * </p>
 *
 * @author testjava
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PayLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String orderNo;

    private Date payTime;
    private BigDecimal totalFee;

    private String transactionId;
    private String tradeState;

    private Integer payType;
    private String attr;

    private Boolean isDeleted;

    private Date gmtCreate;

    private Date gmtModified;


}
