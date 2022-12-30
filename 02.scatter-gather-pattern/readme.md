# Scatter Gather

Let’s consider an application in which we need to do a set of tasks to complete the business workflow. If these tasks do not depend on each other, then it does not make sense to do them sequentially. We can do these tasks in parallel.

![scatter-gather](https://user-images.githubusercontent.com/54174687/210046795-47dcb0e4-7078-4a4a-affc-8a16eed34846.png)

Scatter Gather Pattern helps us to distribute these tasks to achieve parallel processing of tasks/messages/events & finally aggregate the responses as a single response as shown above.

-----

# Sample Application:

Let’s consider a flight booking application in which user searches for flight deals. The application sends the information to all the airlines, find their fares and then responds back.

<img width="693" alt="Screenshot 2022-12-30 at 1 16 08 PM" src="https://user-images.githubusercontent.com/54174687/210046872-0a3397d5-6dee-4b49-baab-10a2f49d5c5e.png">

As our application depends on 3rd party APIs and we need to provide best user experience to our user, we will publish the user request to all airlines and whichever responds within specific timeout period, we will collect all results and show the top 5 deals to our users.

The main application does not even know how many airlines are listening to the requests. Even some of the airlines services are not up and running, it is not going to affect our flight-app.

Execute Endpoint Few times: `http://localhost:8080/scatter-gather/flights/ALT/LAS`

<img width="766" alt="Screenshot 2022-12-30 at 1 10 53 PM" src="https://user-images.githubusercontent.com/54174687/210046699-15d93b27-9ebc-4fac-af06-1fb840fee9f4.png">
