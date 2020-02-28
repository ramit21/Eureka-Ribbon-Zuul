# Eureka-Ribbon-Zuul
POC on the way!!

Start eureka-naming-server(8761), client-app(8000) and the server app(8100). Start more instances of server app with different port nos:

```
-Dserver.port=8101
```
client-app and server-app services are clients to eureka naming server. When the instances of these are brought up, these get registered with the eureka naming server. Open the naming server url and see the applications registered with it:
```
http://localhost:8761
```

Hit client service:
```
http://localhost:8001/client-app-service/greet/Ramit
```
Client will then hit the naming server, which will return a list of registered server apps (as configured in client's feign proxy). Ribbon on the client will then perform client side load balancing in round robin fashion, and send request to the chosen backend service. This server instance will then return the greet message for the name parameter as sent by the client.


**Feign** gives 2 advantages:
1. It is more cleaner than using restTemplate.exchange
2. Can be used with Ribbon for client side load balancing.

Disadvantage: client needs to know the method signature defined at the server end.


