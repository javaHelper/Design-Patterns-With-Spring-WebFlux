# timeout patterns

If we're getting responses within 500 ms, then we can see review detils, if it's greater than 500 ms then no 
review response

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