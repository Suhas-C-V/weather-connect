package org.weather.connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.weather.connect.models.WeatherForecastSummaryModel;
import org.weather.connect.models.WeatherObservationHistoryModel;
import org.weather.connect.service.WeatherService;

import java.io.IOException;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping(path="/forecast/{locationName}/summary", produces = "application/json")
    public WeatherForecastSummaryModel getWeatherForecast(
        @PathVariable("locationName") String locationName
    ) throws IOException {
        return weatherService.getWeatherForecastSummary(locationName);
    }

    @GetMapping(path="/observation/history/{latitude}/{longitude}", produces = "application/json")
    public WeatherObservationHistoryModel getObservationHistory(
        @PathVariable("latitude") String latitude,
        @PathVariable("longitude") String longitude
    ) throws IOException {
        return weatherService.getObservationHistoryByCoordinates(latitude, longitude);
    }
}
