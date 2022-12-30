# Orchestrator Pattern Parallel Workflow

![OWP](https://user-images.githubusercontent.com/54174687/210052810-6d4339d2-f281-48e3-a7b0-d3053e131837.png)

HTTP POST:

```sh
curl --location --request POST 'http://localhost:8080/sec03/order' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": 1,
    "productId": 1,
    "quantity": 1
}'
```

Response:

```json
{
    "userId": 1,
    "productId": 1,
    "orderId": "6b9fe6a2-43c2-46c4-8bd6-484001b27250",
    "status": "SUCCESS",
    "shippingAddress": {
        "street": "746 Hodkiewicz Turnpike",
        "city": "North Louvenia",
        "state": "Kansas",
        "zipCode": "10520-0368"
    },
    "expectedDelivery": "2023-01-02"
}
```
