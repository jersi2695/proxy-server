# Proxy Server Exercise

Simple proxy server that logs the headers of all the HTTP requests it forwards.

## Technologies

This application uses the following key technologies:

- [Java 11](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- [Zuul](https://cloud.spring.io/spring-cloud-netflix/multi/multi__router_and_filter_zuul.html)

## Setup

Under resources directory, open the application.yml file and set url property to the proxied server host.

## Design

This application uses zuul to proxy the server that is desired, and use ZuulFilter abstract class
to filter the response and log the headers of the response.