# Circuit Breaker

```shell
http://localhost:8080/sec08/product/1
```


Execute above endpoint many-many times and you should be able to see below logs. 


```logs

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.1)

2023-09-07 11:48:42.553  INFO 84770 --- [           main] com.example.Application                  : Starting Application using Java 11.0.13 on Prateeks-MacBook-Pro.local with PID 84770 (/Users/prats/Documents/workspace/13.circuite-breaker-pattern/target/classes started by prateekashtikar in /Users/prats/Documents/workspace/13.circuite-breaker-pattern)
2023-09-07 11:48:42.557  INFO 84770 --- [           main] com.example.Application                  : No active profile set, falling back to 1 default profile: "default"
2023-09-07 11:48:46.248  INFO 84770 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint(s) beneath base path '/actuator'
2023-09-07 11:48:46.829  INFO 84770 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080
2023-09-07 11:48:46.855  INFO 84770 --- [           main] com.example.Application                  : Started Application in 4.886 seconds (JVM running for 6.09)
~~~ fallback reviews called : Did not observe any item or terminal signal within 300ms in 'retry' (and no fallback has been configured)
~~~ fallback reviews called : Did not observe any item or terminal signal within 300ms in 'retry' (and no fallback has been configured)
~~~ fallback reviews called : Did not observe any item or terminal signal within 300ms in 'retry' (and no fallback has been configured)
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : Did not observe any item or terminal signal within 300ms in 'retry' (and no fallback has been configured)
~~~ fallback reviews called : Did not observe any item or terminal signal within 300ms in 'retry' (and no fallback has been configured)
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : Did not observe any item or terminal signal within 300ms in 'retry' (and no fallback has been configured)
~~~ fallback reviews called : Did not observe any item or terminal signal within 300ms in 'retry' (and no fallback has been configured)
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
~~~ fallback reviews called : CircuitBreaker 'review-service' is OPEN and does not permit further calls
```