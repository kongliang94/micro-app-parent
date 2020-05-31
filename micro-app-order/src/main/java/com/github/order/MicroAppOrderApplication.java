package com.github.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ComponentScan主要就是定义扫描的路径从中找出标识了需要装配的类自动装配到spring的bean容器中
 * common包中有部分组件需要使用
 */
@ComponentScan(basePackages = {"com.github"})
@EnableDiscoveryClient
@SpringBootApplication
public class MicroAppOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroAppOrderApplication.class, args);
    }

}
