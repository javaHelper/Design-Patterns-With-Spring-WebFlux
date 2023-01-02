# Architectural Pattern – Push Notifications / Messages To The Browser Using Event Stream

# Overview:
In this tutorial, I would like to demo Spring WebFlux Streaming Response (aka Server Sent Events) – a mechanism for pushing notifications/messages to the browsers from the back-end application in real time.

# Spring WebFlux Streaming:
Traditionally browsers have to make a request to the server to fetch the latest information. It has worked just fine so far. When we have to do periodic polling like this, most of the times there might not be any updates! When we have multiple clients bombarding the server every second for updates when there are not much updates, it is simply wasting resources and makes unnecessary network calls.

Server Sent Events is a standard for transmitting data to the client applications using the persistent connection established between the client and the server.  With Server Sent Events (SSE / Event Stream) approach, our server notifies the browser when the server has some updates in more efficient way.

This can be easily achieved by using Spring WebFlux Streaming response.


<img width="1509" alt="Screenshot 2023-01-02 at 2 37 21 PM" src="https://user-images.githubusercontent.com/54174687/210211778-1f95444a-be09-48ea-b9b5-46bc8c63b23e.png">
