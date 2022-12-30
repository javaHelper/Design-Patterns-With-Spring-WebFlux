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

<img width="889" alt="Screenshot 2022-12-30 at 11 18 27 PM" src="https://user-images.githubusercontent.com/54174687/210098781-5c12717c-ef58-47e1-9289-e7b6779bc5f6.png">



Steps:
- It is enabled when the property cache.enabled is set to true.
- It simply extends the NoCache service.
- When we receive the GET request, we would first check the cache, if it is present, we would simply return it. Otherwise, we would query the DB and store in the cache for future use.
- When we receive any PUT/PATCH/DELETE request, we would update the DB first and then we clear the cache immediately. This is important. Otherwise we would serve stale data.
