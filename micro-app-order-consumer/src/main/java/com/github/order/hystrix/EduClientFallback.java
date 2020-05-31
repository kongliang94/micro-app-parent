package com.github.order.hystrix;

import com.github.entity.ordervo.CourseWebVoOrder;
import com.github.order.client.EduClient;
import org.springframework.stereotype.Component;

/**
 * @description: educlient 的熔断器
 * @author: KL
 * @create: 2020-05-30
 */
@Component
public class EduClientFallback implements EduClient {
    @Override
    public CourseWebVoOrder getCourseInfoOrder(String id) {
        return null;
    }
}
