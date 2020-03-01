# Eureka-Ribbon-Zuul

**Netflix-Eureka:** Naming server

**Ribbon:** Client-side load balancer

**Netflix-Zuul:** API Gateway

Start eureka-naming-server(port=8761), client-app(8000), server-app(8100) and Api-gateway (9000). Start more instances of server app with different port nos:

```
-Dserver.port=8101
```
Client-app, server-app and zuul-gateway services are clients to eureka naming server. When the instances of these are brought up, these get registered with the eureka naming server. Open the naming server URL and see the applications registered with it:
```
http://localhost:8761
```

Url to hit the server from the client app (via naming server):
```
http://localhost:8001/client-app-service/greet/Ramit
```
The client will then hit the naming server, which will return a list of registered server apps (as configured in the client's feign proxy). Ribbon on the client will then perform client side load balancing in round-robin fashion, and send request to the chosen backend service. This server instance will then return the greet message for the name parameter as sent by the client. Hit the URL again and notice a different server port returning the response.

Url to hit the server via API gateway: (hit below URL, and see Zuul do the logging for the request)

http://<api-gateway-host>:port/{server-application-name}/{uri}
```
http://localhost:9000/client-app-service/client-app-service/greet/Ramit
```
When you hit the backend service via API gateway, you can notice the gateway filter doing logging for us. We can achieve lot more with the API gateway as mentioned below.

**API gateway uses:**
1. Authentication and authorisation
2. Rate limit
3. Fault tolerance
4. Service aggregation

**Feign Client** gives 2 advantages:
1. It is cleaner than using restTemplate.exchange
2. Can be used with Ribbon for client-side load balancing.

Disadvantage: client needs to know the method signature defined at the server end.


 
**References**
https://www.linkedin.com/pulse/server-vs-client-side-load-balancing-ramit-sharma
