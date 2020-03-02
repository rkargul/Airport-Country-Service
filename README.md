# Airport-Country-Service

## Requirements:
The application runs on Java 8.
Docker used to run two services on separate ports.

## Pre-requisites:
Application will load data from both input endpoints
Make sure you are running both services provided below:
Image 'countries':

```docker build -t countries -f src/main/resources/apis/docker-countries/Dockerfile .```

```docker run -p 8085:8080 countries```



Image 'airports': 

```docker build -t airports -f src/main/resources/apis/docker-airports/Dockerfile .```

```docker run -p 8086:8080 airports```

Check Docker IP address: ```docker-machine ip```


## Available endpoints:

By default, the endpoints listed below will run on ```localhost:8080```:

```/airportcountrysummary```

Query for minimumrunways:
```/airportcountrysummary?runways=``` put a number of runways to filter on

For example, ```localhost:8080/airportcountrysummary?runways=6``` will display all countries and list all airports that have at least 6 runways.

## 
