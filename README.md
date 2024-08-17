# Getting Started

### Setting Up Guide for Java Spring Boot Maven Project

#### Prerequisites
- Java Development Kit (JDK) 17 or higher
- Apache Maven 3.6.0 or higher
- An IDE such as IntelliJ IDEA

#### Steps

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Import the Project into IntelliJ IDEA**
    - Open IntelliJ IDEA.
    - Select `File` -> `Open...`.
    - Navigate to the cloned repository directory and select it.
    - IntelliJ IDEA will automatically detect the Maven project and import it.

3. **Configure JDK**
    - Go to `File` -> `Project Structure...`.
    - Under `Project Settings`, select `Project`.
    - Set the `Project SDK` to the installed JDK version.

4. **Build the Project**
   ```bash
   mvn clean install
   ```

5. **Run the Application**
    - In IntelliJ IDEA, navigate to the `WeatherController` class.
    - Right-click on the class and select `Run 'WeatherController'`.

6. **Access the API**
    - Open a web browser or use a tool like `curl` or Postman.
    - Access the API endpoints:
        - `GET /weather/forecast/{locationName}/summary`
        - `GET /weather/observation/history/{latitude}/{longitude}`

#### Example Requests
- **Get Weather Forecast Summary**
  ```bash
  curl -X GET "http://localhost:8080/weather/forecast/London/summary"
  ```

- **Get Weather Observation History**
  ```bash
  curl -X GET "http://localhost:8080/weather/observation/history/51.5074/-0.1278"
  ```

#### Additional Resources
- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/)

This guide should help you set up and run the Java Spring Boot Maven project successfully.

---
### Weather API Documentation

#### Base URL
`/weather`

---

#### Get Weather Forecast Summary

**Endpoint:** `/forecast/{locationName}/summary`

**Method:** `GET`

**Produces:** `application/json`

**Path Parameters:**
- `locationName` (String): The name of the location for which the weather forecast summary is requested.

**Response:**
- **200 OK**: Returns a `WeatherForecastSummaryModel` object containing the weather forecast summary for the specified location.

**Example Request:**
```bash
GET /weather/forecast/London/summary
```

**Example Response:**
```json
{
  "location": {
    "code": "123",
    "name": "London",
    "timezone": "GMT",
    "coordinates": {
      "latitude": 51.5074,
      "longitude": -0.1278
    }
  },
  "forecast": {
    "items": [
      {
        "date": "2023-10-01",
        "dateWithTimezone": "2023-10-01T00:00:00Z",
        "freshSnow": 0.0,
        "snowHeight": null,
        "weather": {
          "state": 1,
          "text": "Clear",
          "icon": "clear.png"
        },
        "prec": {
          "sum": 0.0,
          "probability": 0,
          "sumAsRain": null,
          "classification": 0
        },
        "sunHours": 10,
        "rainHours": 0.0,
        "temperature": {
          "min": 10,
          "max": 20,
          "avg": 15.0
        },
        "wind": {
          "unit": "km/h",
          "direction": "N",
          "text": "North",
          "avg": 5.0,
          "min": 2,
          "max": 10,
          "gusts": {
            "value": 15,
            "text": "Moderate"
          },
          "significationWind": false
        },
        "windchill": {
          "min": 8,
          "max": 18,
          "avg": 13.0
        },
        "snowLine": {
          "avg": null,
          "min": null,
          "max": null,
          "unit": "m"
        },
        "astronomy": {
          "dawn": "06:00",
          "sunrise": "06:30",
          "suntransit": "12:00",
          "sunset": "18:30",
          "dusk": "19:00",
          "moonrise": "20:00",
          "moontransit": "00:00",
          "moonset": "04:00",
          "moonphase": 1,
          "moonzodiac": 2
        }
      }
    ],
    "forecastDate": "2023-10-01",
    "nextUpdate": "2023-10-02",
    "source": "WeatherAPI",
    "point": "London"
  }
}
```

---

#### Get Weather Observation History

**Endpoint:** `/observation/history/{latitude}/{longitude}`

**Method:** `GET`

**Produces:** `application/json`

**Path Parameters:**
- `latitude` (String): The latitude of the location for which the weather observation history is requested.
- `longitude` (String): The longitude of the location for which the weather observation history is requested.

**Response:**
- **200 OK**: Returns a `WeatherObservationHistoryModel` object containing the weather observation history for the specified coordinates.

**Example Request:**
```bash
GET /weather/observation/history/51.5074/-0.1278
```

**Example Response:**
```json
{
  "id": "1",
  "name": "London",
  "type": "City",
  "distance": 0,
  "coordinates": {
    "latitude": 51.5074,
    "longitude": -0.1278,
    "elevation": 35.0
  },
  "history": [
    {
      "summary": "Clear day",
      "details": [
        {
          "date": "2023-09-30",
          "temperature": {
            "unit": "C",
            "avg": 15.0,
            "min": 10.0,
            "max": 20.0
          },
          "wind": {
            "unit": "km/h",
            "direction": "N",
            "text": "North",
            "avg": 5.0,
            "min": 2.0,
            "max": 10.0,
            "gusts": {
              "value": 15.0,
              "text": "Moderate"
            },
            "significationWind": false
          },
          "pressure": 1015.0
        }
      ]
    }
  ]
}
```

---

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.2/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.2/maven-plugin/build-image.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#using.devtools)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#web.security)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
