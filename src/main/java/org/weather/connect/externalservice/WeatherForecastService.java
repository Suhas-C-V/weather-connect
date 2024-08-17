package org.weather.connect.externalservice;


import org.weather.connect.models.WeatherForecastSummaryModel;
import org.weather.connect.models.WeatherObservationHistoryModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherForecastService {

  @GET("/rapidapi/forecast/{locationName}/summary/")
  Call<WeatherForecastSummaryModel> getWeatherForecastSummary(
      @Path("locationName") String locationName
  );

  @GET("/rapidapi/station/nearBy/{latitude}/{longitude}/")
  Call<WeatherObservationHistoryModel> getObservationHistoryByCoordinates(
      @Path("latitude") String latitude,
      @Path("longitude") String longitude
  );

}
