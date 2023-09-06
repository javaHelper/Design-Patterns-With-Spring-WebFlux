# Retry Patterns

- Review Service: 
Provides the list of Review for the given product id. 70% of the requests will fail. Each requests take up to 30ms

````
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.4)

2023-09-06 20:17:17.986  INFO 65048 --- [           main] c.v.e.ExternalServicesApplication        : Starting ExternalServicesApplication v0.0.1-SNAPSHOT using Java 11.0.13 on Prateeks-MacBook-Pro.local with PID 65048 (/Users/prats/Downloads/external-services-v2.jar started by prateekashtikar in /Users/prats/Downloads)
2023-09-06 20:17:17.996  INFO 65048 --- [           main] c.v.e.ExternalServicesApplication        : No active profile set, falling back to 1 default profile: "default"
2023-09-06 20:17:25.424  INFO 65048 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 7070
2023-09-06 20:17:26.895  INFO 65048 --- [           main] c.v.e.ExternalServicesApplication        : Started ExternalServicesApplication in 10.451 seconds (JVM running for 11.653)
2023-09-06 20:17:33.675 ERROR 65048 --- [ctor-http-nio-3] c.v.e.s.retry.service.ReviewService7     : Review service - some error occurred
2023-09-06 20:18:04.163  INFO 65048 --- [ctor-http-nio-4] c.v.e.s.retry.service.ReviewService7     : finding reviews for product 1
2023-09-06 20:18:07.539 ERROR 65048 --- [ctor-http-nio-4] c.v.e.s.retry.service.ReviewService7     : Review service - some error occurred
2023-09-06 20:18:07.616 ERROR 65048 --- [ctor-http-nio-2] c.v.e.s.retry.service.ReviewService7     : Review service - some error occurred
2023-09-06 20:18:07.664  INFO 65048 --- [ctor-http-nio-4] c.v.e.s.retry.service.ReviewService7     : finding reviews for product 1
2023-09-06 20:18:11.117 ERROR 65048 --- [ctor-http-nio-4] c.v.e.s.retry.service.ReviewService7     : Review service - some error occurred
2023-09-06 20:18:11.163 ERROR 65048 --- [ctor-http-nio-2] c.v.e.s.retry.service.ReviewService7     : Review service - some error occurred
2023-09-06 20:18:11.196  INFO 65048 --- [ctor-http-nio-4] c.v.e.s.retry.service.ReviewService7     : finding reviews for product 1
2023-09-06 20:18:13.497 ERROR 65048 --- [ctor-http-nio-4] c.v.e.s.retry.service.ReviewService7     : Review service - some error occurred
2023-09-06 20:18:13.539 ERROR 65048 --- [ctor-http-nio-2] c.v.e.s.retry.service.ReviewService7     : Review service - some error occurred
2023-09-06 20:18:13.586 ERROR 65048 --- [ctor-http-nio-4] c.v.e.s.retry.service.ReviewService7     : Review service - some error occurred
2023-09-06 20:18:13.620 ERROR 65048 --- [ctor-http-nio-2] c.v.e.s.retry.service.ReviewService7     : Review service - some error occurred
2023-09-06 20:18:13.642  INFO 65048 --- [ctor-http-nio-4] c.v.e.s.retry.service.ReviewService7     : finding reviews for product 1
````

Executes below endpoint few times to see the above logs 
````
http://localhost:8080/sec07/product/1
````

````
{
    "id": 1,
    "category": "Computers",
    "description": "Durable Wooden Plate",
    "reviews": [
        {
            "id": 1,
            "user": "Waldo",
            "rating": 5,
            "comment": "Explicabo eum ut."
        },
        {
            "id": 2,
            "user": "Asa",
            "rating": 1,
            "comment": "Recusandae rem consequatur."
        },
        {
            "id": 3,
            "user": "Wanita",
            "rating": 4,
            "comment": "Atque vitae non quod."
        },
        {
            "id": 4,
            "user": "Brandee",
            "rating": 3,
            "comment": "Velit dolorum corporis repellat repellendus quo quae deserunt."
        },
        {
            "id": 5,
            "user": "Ingeborg",
            "rating": 4,
            "comment": "Dolorem veritatis reprehenderit voluptates repellat distinctio."
        },
        {
            "id": 6,
            "user": "Wanita",
            "rating": 2,
            "comment": "Ut nesciunt explicabo magnam recusandae magnam quos."
        },
        {
            "id": 7,
            "user": "Zana",
            "rating": 5,
            "comment": "Aliquid sed natus est."
        },
        {
            "id": 8,
            "user": "Dexter",
            "rating": 3,
            "comment": "Tempora quos eum voluptatibus molestias sunt sequi."
        },
        {
            "id": 9,
            "user": "Fernanda",
            "rating": 5,
            "comment": "Expedita atque minima."
        }
    ]
}
````