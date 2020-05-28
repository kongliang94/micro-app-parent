package com.github.order.config;

import com.github.order.handler.OrderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.*;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class FnMvcConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(OrderHandler postHandler) {
        return route(GET("/orders"), postHandler::all)
                .andRoute(POST("/orders"), postHandler::create)
                .andRoute(GET("/orders/{id}"), postHandler::get)
                .andRoute(GET("/eduorder/order/isBuyCourse/{courseId}/{memberId}"),postHandler::isBuyCourse)
                .andRoute(GET("/orders/no/{orderNo}"), postHandler::getByNo)
                .andRoute(PUT("/orders/{id}"), postHandler::update)
                .andRoute(GET("/orders/count"),postHandler::selectCount)
                .andRoute(DELETE("/orders/{id}"), postHandler::delete);
    }
}
