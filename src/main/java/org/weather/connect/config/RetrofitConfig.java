package org.weather.connect.config;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.weather.connect.externalservice.WeatherForecastService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.time.Duration;

@Configuration
public class RetrofitConfig {

    private static final int DEFAULT_TIME_OUT_IN_SECS = 10;

    @Value("${weather.rapid.api.host}")
    String host;

    @Value("${weather.rapid.api.key}")
    String key;


  @Bean
    public WeatherForecastService weatherForecastService() {

//      HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//      logging.setLevel(HttpLoggingInterceptor.Level.BODY);

      OkHttpClient httpClient = new OkHttpClient.Builder()
          .addInterceptor(new RequestInterceptor(host, key))
          .readTimeout(Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECS))
//          .addInterceptor(logging)
          .build();

        return new Retrofit.Builder()
            .baseUrl("https://forecast9.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(WeatherForecastService.class);
    }
}
