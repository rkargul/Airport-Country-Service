# LunatechAssignment

## Running Docker Images:

Image 'airports': 

```docker build -t airports -f src/main/resources/apis/docker-airports/Dockerfile .```

```docker run -p 8085:8080 airports```


Image 'countries':

```docker build -t countries -f src/main/resources/apis/docker-countries/Dockerfile .```

```docker run -p 8085:8080 countries```

## Available endpoints:

```/airportcountrysummary```
