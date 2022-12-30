# Splitter Pattern

````
curl --location --request POST 'http://localhost:8080/splitter/reserve' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "city": "ATLANTA",
        "from": "2022-05-01",
        "to": "2022-05-02",
        "type": "CAR"
    }
]'
````

Response:

````
{
    "reservationId": "b5fdb7fd-57f8-4064-8c71-e88179ccf06a",
    "price": 46,
    "items": [
        {
            "itemId": "802198b2-0653-4c8f-af66-6807d18436d9",
            "type": "CAR",
            "category": "STANDARD",
            "city": "ATLANTA",
            "from": "2022-05-01",
            "to": "2022-05-02",
            "price": 46
        }
    ]
}
````

----

````
curl --location --request POST 'http://localhost:8080/splitter/reserve' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "city": "ATLANTA",
        "from": "2022-05-01",
        "to": "2022-05-02",
        "type": "CAR"
    },
    {
        "city": "ATLANTA",
        "from": "2022-05-01",
        "to": "2022-05-02",
        "type": "ROOM"
    }
]'
````

Response:

````
{
    "reservationId": "978b970a-51f4-4edd-b21c-ffc902c076f9",
    "price": 136,
    "items": [
        {
            "itemId": "8eb57be2-144a-4e0d-bb54-f037d1b311b1",
            "type": "CAR",
            "category": "STANDARD",
            "city": "ATLANTA",
            "from": "2022-05-01",
            "to": "2022-05-02",
            "price": 68
        },
        {
            "itemId": "7b64f128-0675-4182-8fc4-d65e306fa822",
            "type": "ROOM",
            "category": "KING",
            "city": "ATLANTA",
            "from": "2022-05-01",
            "to": "2022-05-02",
            "price": 68
        }
    ]
}
````
----

````
curl --location --request POST 'http://localhost:8080/splitter/reserve' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "city": "ATLANTA",
        "from": "2022-05-01",
        "to": "2022-05-02",
        "type": "CAR"
    },
    {
        "city": "ATLANTA",
        "from": "2022-05-01",
        "to": "2022-05-02",
        "type": "ROOM"
    },
    {
        "city": "ATLANTA",
        "from": "2022-05-03",
        "to": "2022-05-04",
        "type": "CAR",
        "category": "LUXURY"
    }
]'
````

Response:

````
{
    "reservationId": "5a67b6cc-58e8-428c-a57d-ff00f395c672",
    "price": 190,
    "items": [
        {
            "itemId": "58d84068-9e76-451e-ac1f-ac9a028b94a6",
            "type": "CAR",
            "category": "STANDARD",
            "city": "ATLANTA",
            "from": "2022-05-01",
            "to": "2022-05-02",
            "price": 63
        },
        {
            "itemId": "0529c37d-3603-42bc-ad77-13c742e972dd",
            "type": "CAR",
            "category": "LUXURY",
            "city": "ATLANTA",
            "from": "2022-05-03",
            "to": "2022-05-04",
            "price": 65
        },
        {
            "itemId": "edab9729-c770-4c28-ad2f-a0d8d3faa594",
            "type": "ROOM",
            "category": "KING",
            "city": "ATLANTA",
            "from": "2022-05-01",
            "to": "2022-05-02",
            "price": 62
        }
    ]
}
````