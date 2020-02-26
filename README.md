# Eureka-Ribbon-Zuul
POC on the way!!


To start a microservice on a port different from the one defined in application.properties, give below as 
runtime argument:
```
-Dserver.port=8001
```
Giving different ports we can start different instances of the microservice.

Hit client service:
```
http://localhost:8001/client-app-service/greet/Ramit
```
Client will then hit server api url below via Feign client:
```
http://localhost:8100/server-app-service/greet/Ramit
```

**Feign client:**

Import feign dependency and enable feign on the main class.

Feign gives 2 advantages:
1. More cleaner than using restTemplate.exchange
2. Can be used with Ribbon for client side load balancing.

Disadvantage: client needs to know the method signature defined at the server end.


