# Getting Started

## Requirements

Java 1.8+

## Execute

"Technically" should run with:

`mvn spring-boot:run` in any operating system that has Java and Maven installed.

## Test

Besides the one unit test, send:

`POST http://localhost:8080/shorts` with the desired URL on the body.
You should receive a response (200) body with the shortened URL.

To consume, send:

`GET [response_url]`. This will redirect (303) to the original URL.
