api-gateway

- Spring Cloud Gateway，設定路徑及請求過濾filter

currency-conversion-service

- Feign，透過Feign proxy代理呼叫currency-exchange-service服務
- Resilience4j，通過斷路器模式保護微服務

currency-exchange-service

naming-server

- Eureka，包含Spring Cloud LoadBalancer，負責註冊服務及負載平衡  
  
  
Limits Service
  http://localhost:8080/limits  
  
Cloud Config Server  
  http://localhost:8888/limits-service/default  
  http://localhost:8888/limits-service/qa  
  http://localhost:8888/limits-service/dev  
  
Currency Exchange Service  
  http://localhost:8000/currency-exchange/from/USD/to/INR  
    
Currency Conversion Service  
  http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10  
  http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10  

Eureka  
  http://localhost:8761/  
  
Spring Cloud Api Gateway  
Initial  
  http://localhost:8765/CURRENCY-EXCHANGE/currency-exchange/from/USD/to/INR  
  http://localhost:8765/CURRENCY-CONVERSION/currency-conversion/from/USD/to/INR/quantity/10  
  http://localhost:8765/CURRENCY-CONVERSION/currency-conversion-feign/from/USD/to/INR/quantity/10  
  
Intermediate  
  http://localhost:8765/currency-exchange/currency-exchange/from/USD/to/INR  
  http://localhost:8765/currency-conversion/currency-conversion/from/USD/to/INR/quantity/10  
  http://localhost:8765/currency-conversion/currency-conversion-feign/from/USD/to/INR/quantity/10  
  
Final  
  http://localhost:8765/currency-exchange/from/USD/to/INR  
  http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10  
  http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10  
  http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10  
