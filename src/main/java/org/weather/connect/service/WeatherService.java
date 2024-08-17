package org.weather.connect.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.weather.connect.externalservice.WeatherForecastService;
import org.weather.connect.models.WeatherForecastSummaryModel;
import org.weather.connect.models.WeatherObservationHistoryModel;
import retrofit2.Response;

import java.io.IOException;

@Service
public class WeatherService {

  @Autowired
  private WeatherForecastService weatherForecastService;

  public WeatherForecastSummaryModel getWeatherForecastSummary(String locationName)
      throws IOException {

      Response<WeatherForecastSummaryModel> weatherForecastSummaryRes =
          weatherForecastService.getWeatherForecastSummary(locationName).execute();

      return weatherForecastSummaryRes.body();
  }

  public WeatherObservationHistoryModel getObservationHistoryByCoordinates(String latitude, String longitude)
      throws IOException {

      Response<WeatherObservationHistoryModel> observationHistoryRes =
          weatherForecastService.getObservationHistoryByCoordinates(latitude, longitude).execute();

      return observationHistoryRes.body();
  }
}
