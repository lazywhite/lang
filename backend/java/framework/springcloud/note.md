## Introduction
```
common patterns in distribute system
    configuration management
    serivice discovery
    circuit breakers
    intelligent routing
    micro-proxy
    control bus
    one-time token
    global lock
    leadership election
    distribute session
    cluster state
   
```
## Tips
```
SOA强调把大的业务拆分成不同的application
微服务强调把单个application拆分成小的component

ConfigServer: 提供统一配置
Feign: 使用了ribbon
Ribbon: 客户端负载均衡
Hystrix: 断路器, 一般跟Feign配合使用
Eureka: 服务注册中心, 提供被动式服务发现
Zuul: api网关, 提供集中认证, CORS, 协议统一
Bus: 提供配置更新通知
```
