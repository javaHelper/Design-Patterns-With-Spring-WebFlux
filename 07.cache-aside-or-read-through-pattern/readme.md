# Redis Cache Aside / Read Through Pattern

<img width="479" alt="Screenshot 2022-12-30 at 11 14 19 PM" src="https://user-images.githubusercontent.com/54174687/210098483-212d96d3-4f41-4694-a95c-dcec24cb2af9.png">


When somebody is updating the product details, we're intentionally deleting it from cache and it the get call updating back into the cache.

----

HTTP GET 

```
http://localhost:8080/product/100
```

Response:

````
{
    "id": 100,
    "description": "Product100",
    "price": 1756,
    "quantityAvailable": 8116
}
````

Steps:
1. When we pass ProductId to get the Product Info, it first lookup into redis cache and if data present then it will be return back to client.
2. When we pass ProductId to get the Product Info, it first lookup into redis cache and if data not present then it will go to PostgresDB, before returning back to client, it updates redis.
3. When we update the Product details, it removes Product details from cache and update the db.
