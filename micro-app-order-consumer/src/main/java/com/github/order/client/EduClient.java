package com.github.order.client;


import com.github.entity.ordervo.CourseWebVoOrder;
import com.github.order.hystrix.EduClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient(value = "jplaceholder",
//        url = "https://jsonplaceholder.typicode.com/",
//        configuration = ClientConfiguration.class,
//        fallback = JSONPlaceHolderFallback.class)
@Component
@FeignClient(value = "service-edu",fallback = EduClientFallback.class)
public interface EduClient {

    //根据课程id查询课程信息
    @PostMapping("/eduservice/coursefront/getCourseInfoOrder/{id}")
    public CourseWebVoOrder getCourseInfoOrder(@PathVariable("id") String id);

}
