# springcloudalibaba 组件学习
## 依赖nacos注册中心，配置中心
需要先启动nacos


### springcloud nacos quickstart
https://nacos.io/zh-cn/docs/quick-start-spring-cloud.html

注意：之所以需要配置 spring.application.name ，是因为它是构成 Nacos 配置管理 dataId字段的一部分。

在 Nacos Spring Cloud 中，dataId 的完整格式如下：

`${prefix}-${spring.profile.active}.${file-extension}`

prefix 默认为 spring.application.name 的值，也可以通过配置项 spring.cloud.nacos.config.prefix来配置。

spring.profile.active 即为当前环境对应的 profile，详情可以参考 Spring Boot文档。 注意：当 spring.profile.active 为空时，对应的连接符 - 也将不存在，dataId 的拼接格式变成 ${prefix}.${file-extension}

file-exetension 为配置内容的数据格式，可以通过配置项 spring.cloud.nacos.config.file-extension 来配置。目前只支持 properties 和 yaml 类型。

## 使用spring-cloud-gateway网关

## order-service-provider 提供两种风格的接口