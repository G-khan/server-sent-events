# Sample Live Score app - Spring Boot Reactive Webflux Server-Sent Events

This is a sample live score application that shows how to use Server-Sent Events:
- Spring Webflux

## Article
[What are the Server Sent Events and More..](https://gokhana.medium.com)

## Running

Run this using the gradle:

```
gradle bootRun
```

This will start the application on port 8080.

### For sending the live scores to the clients
```  
curl --location --request POST 'http://localhost:8080/api/v1/live-scores' \
--header 'Content-Type: application/json' \
--data-raw '{
    "homeTeam": "GS",
    "awayTeam": "FB",
    "homeScore": 3,
    "awayScore": 0
}' 
```

### Starting the Server Sent Events for consuming live scores
```
curl --location --request POST 'http://localhost:8080/api/v1/live-scores' \
--header 'Content-Type: application/json' \
--data-raw '{
"homeTeam": "GS",
"awayTeam": "FB",
"homeScore": 3,
"awayScore": 0
}' 
```
