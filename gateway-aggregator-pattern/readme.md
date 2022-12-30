# Aggregator Pattern

WebClient call will be performed all in parallel. So in this section, we were mostly looking into the gateway aggregator, but so the main purpose of this is to hide the backend complexity and that acts like a facade for that land. It receives the request from the client and calls all the upstream aggregates and send it back to that

To Simulate the whether WebClient works parallely, use `java -jar external-services-v2.jar --sec01.delay.response=3000` and star the app.

![Aggregator-pattern](https://user-images.githubusercontent.com/54174687/210042083-95c155c4-c371-488a-acdd-5b571713bd4c.png)


````
http://localhost:8080/aggregate/product/2
````

Response:

````
{
    "id": 2,
    "category": "Shoes",
    "description": "Enormous Steel Clock",
    "price": {
        "listPrice": 49,
        "discount": 18.75,
        "discountedPrice": 39.8125,
        "amountSaved": 9.1875,
        "endDate": "2022-12-31"
    },
    "reviews": [
        {
            "id": 1,
            "user": "Elly",
            "rating": 5,
            "comment": "Enim eos dolorem enim."
        },
        {
            "id": 2,
            "user": "Oren",
            "rating": 5,
            "comment": "Voluptas facilis explicabo qui quas facere."
        },
        {
            "id": 3,
            "user": "Ted",
            "rating": 2,
            "comment": "Magnam sit voluptatem velit non earum voluptate blanditiis."
        },
        {
            "id": 4,
            "user": "Willie",
            "rating": 4,
            "comment": "Nobis aut consectetur pariatur quam maxime."
        },
        {
            "id": 5,
            "user": "Abram",
            "rating": 3,
            "comment": "Ea excepturi eos vel aperiam."
        },
        {
            "id": 6,
            "user": "King",
            "rating": 5,
            "comment": "Dolorum porro autem aut sint facilis aperiam."
        },
        {
            "id": 7,
            "user": "Ileana",
            "rating": 5,
            "comment": "Praesentium voluptatem explicabo omnis sapiente sunt."
        },
        {
            "id": 8,
            "user": "Gerald",
            "rating": 2,
            "comment": "Officia quos cum ea necessitatibus numquam eum nemo."
        },
        {
            "id": 9,
            "user": "Ginger",
            "rating": 5,
            "comment": "Commodi tempore aut."
        }
    ]
}
````

We've safely handled all the conditions in Product-service, Promotion-Service and Review-Service. For ex:

`http://localhost:8080/aggregate/product/51` - This nothing will return.
