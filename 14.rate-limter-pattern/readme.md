# rate-limiter-pattern

Promotes product sales by providing realistic Positive Reviews for the given product id. You need to pay $ for every 
request. Enable log by passing this property sec09.log.enabled=true to see the charges

http://localhost:8080/sec09/product/1

````shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.4)

2023-09-07 12:18:32.136  INFO 87377 --- [           main] c.v.e.ExternalServicesApplication        : Starting ExternalServicesApplication v0.0.1-SNAPSHOT using Java 11.0.13 on Prateeks-MacBook-Pro.local with PID 87377 (/Users/prats/Downloads/external-services-v2.jar started by prateekashtikar in /Users/prats/Downloads)
2023-09-07 12:18:32.145  INFO 87377 --- [           main] c.v.e.ExternalServicesApplication        : No active profile set, falling back to 1 default profile: "default"
2023-09-07 12:18:38.307  INFO 87377 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 7070
2023-09-07 12:18:39.398  INFO 87377 --- [           main] c.v.e.ExternalServicesApplication        : Started ExternalServicesApplication in 8.509 seconds (JVM running for 9.556)
2023-09-07 12:18:46.502  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 0. Expected charges $ 0 USD
2023-09-07 12:18:56.499  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 0. Expected charges $ 0 USD
2023-09-07 12:19:06.500  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 0. Expected charges $ 0 USD
2023-09-07 12:19:16.499  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 0. Expected charges $ 0 USD
2023-09-07 12:19:26.501  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 0. Expected charges $ 0 USD
2023-09-07 12:19:36.501  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 0. Expected charges $ 0 USD
2023-09-07 12:19:46.501  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 0. Expected charges $ 0 USD
2023-09-07 12:19:56.498  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 0. Expected charges $ 0 USD
2023-09-07 12:20:06.500  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 1. Expected charges $ 5 USD
2023-09-07 12:20:16.498  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 3. Expected charges $ 15 USD
2023-09-07 12:20:26.502  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 6. Expected charges $ 30 USD
2023-09-07 12:20:36.498  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 6. Expected charges $ 30 USD
2023-09-07 12:20:46.500  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 8. Expected charges $ 40 USD
2023-09-07 12:20:56.500  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 9. Expected charges $ 45 USD
2023-09-07 12:21:06.502  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 10. Expected charges $ 50 USD
2023-09-07 12:21:16.502  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 10. Expected charges $ 50 USD
2023-09-07 12:21:26.503  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 10. Expected charges $ 50 USD
2023-09-07 12:21:36.500  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 10. Expected charges $ 50 USD
2023-09-07 12:21:46.507  INFO 87377 --- [     parallel-2] c.v.e.s.r.service.ReviewService9         : Review service calls 10. Expected charges $ 50 USD
````