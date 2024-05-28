api-gateway

- Spring Cloud Gateway，設定路徑及請求過濾filter

currency-conversion-service

- Feign，透過Feign proxy代理呼叫currency-exchange-service服務
- Resilience4j，通過斷路器模式保護微服務

currency-exchange-service

naming-server

- Eureka，包含**Spring Cloud LoadBalancer，**負責註冊服務及負載平衡
