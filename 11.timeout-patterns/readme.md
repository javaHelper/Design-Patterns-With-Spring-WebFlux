# timeout patterns

If we're getting responses within 500 ms, then we can see review detils, if it's greater than 500 ms then no 
review response

```java
@Service
public class ProductClient {

    private final WebClient client;

    public ProductClient(@Value("${sec06.product.service}") String baseUrl){
        this.client = WebClient.builder()
                               .baseUrl(baseUrl)
                               .build();
    }

    public Mono<Product> getProduct(Integer id){
        return this.client
                .get()
                .uri("{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .timeout(Duration.ofMillis(500))  // Here is how we're managing timeouts
                .onErrorResume(ex -> Mono.empty());
    }
}
```

http://localhost:8080/sec06/product/1

````
{
    "id": 1,
    "category": "Sports",
    "description": "Gorgeous Marble Lamp",
    "reviews": []
}
````

````
{
    "id": 1,
    "category": "Sports",
    "description": "Gorgeous Marble Lamp",
    "reviews": [
        {
            "id": 1,
            "user": "Perry",
            "rating": 5,
            "comment": "Illum pariatur rerum hic odio ut ut ut."
        },
        {
            "id": 2,
            "user": "Ernestina",
            "rating": 4,
            "comment": "Enim fuga voluptatem eum quis et alias sequi."
        }
    ]
}
````
