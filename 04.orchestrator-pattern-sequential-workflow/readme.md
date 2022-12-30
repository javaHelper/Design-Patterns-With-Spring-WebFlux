#

````
curl --location --request POST 'http://localhost:8080/sec04/order' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": 1,
    "productId": 1,
    "quantity": 1
}'
````

Response:

````
{
    "userId": 1,
    "productId": 1,
    "orderId": "6c5848c1-76e2-4e2e-bb8d-cc2560f95c23",
    "status": "SUCCESS",
    "shippingAddress": {
        "street": "56249 Missy Roads",
        "city": "South Tashia",
        "state": "Kansas",
        "zipCode": "97130-8453"
    },
    "expectedDelivery": "2023-01-01"
}
````