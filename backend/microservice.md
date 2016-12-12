# Characteristic of MicroService
1. componetiation via services
2. organized around business capabilities
3. products not projects
4. smart endpoints and dumb pipes
5. decentrialized governance
6. decentrialized data management
7. infrastructure automation
8. design for failure
9. evolutionary design 
  
## requirement to use microService
1. rapid provisioning
2. basic monitoring
3. rapid application deployment
4. devops culture
 
## Keyword
```
component: independently replaceable, upgradeable
    library
    service
```
## 微服务好处
1. 解耦合  
2. 异构化  
3. 易扩容  
4. 容灾  
5. 垂直切分数据  

  
## 坏处
1. 服务通过网络通信，处理时间变长  
2. 不可靠性较大  

  
## Topic
### 1. SOA
SOA: service oriented architecture    
ESB: enterprise service bus    

### 2. service register
1. client side: client talk to "Registry" directly 
2. third-party side: client talk to "ServiceManager" then ServiceManager talk to "Registry"
  
### 3. service discovery
client side: talk to "Registry" then get "Service Location", talk to "API-Gateway", finally "Service"  
server side: talk to "API-Gateway" directly, "API-Gateway" talk with "Registry" then call "Service"  
  
### 4. tools
```
zookeeper
etcd
consul
skyDNS
MesosDNS
Spartan
```
### 5. REST API
```
components
    resources
    methods
    representation: json or trift
```
