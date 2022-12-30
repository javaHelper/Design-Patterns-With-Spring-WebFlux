# Aggregator Pattern

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