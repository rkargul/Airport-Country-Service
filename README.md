# Airport-Country-Service

## Requirements:
The application runs on Java 8.

## Running Docker Images [Windows 10]:

Check Docker IP address: ````docker-machine ip```

Image 'countries':

```docker build -t countries -f src/main/resources/apis/docker-countries/Dockerfile .```

```docker run -p 8085:8080 countries```



Image 'airports': 

```docker build -t airports -f src/main/resources/apis/docker-airports/Dockerfile .```

```docker run -p 8086:8080 airports```


## Available endpoints:

```/airportcountrysummary```

Query for minimumrunways:
```/airportcountrysummary?runways=``` put a number of runways to filter on

## 
