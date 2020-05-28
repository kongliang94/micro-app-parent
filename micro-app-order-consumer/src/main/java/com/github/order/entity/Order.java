package com.github.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author testjava
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id;

    private String orderNo;

    private String courseId;

    private String courseTitle;

    private String courseCover;

    private String teacherName;

    private String memberId;
    private String nickname;

    private String mobile;

    private BigDecimal totalFee;

    private Integer payType;

    private Integer status;

    private Boolean isDeleted;

    private Date gmtCreate;

    private Date gmtModified;


}
