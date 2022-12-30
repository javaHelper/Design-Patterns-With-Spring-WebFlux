# 

when somebody is updating the product details, we're intentionally deleting it from cache and it the get call updating back into the cache.

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