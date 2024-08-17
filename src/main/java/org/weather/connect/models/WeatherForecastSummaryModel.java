package org.weather.connect.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class WeatherForecastSummaryModel {
  private Location location;
  private Forecast forecast;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Location {
    private String code;
    private String name;
    private String timezone;
    private Coordinates coordinates;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Coordinates {
    private double latitude;
    private double longitude;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Forecast {
    private List<Item> items;
    private String forecastDate;
    private String nextUpdate;
    private String source;
    private String point;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Item {
    private String date;
    private String dateWithTimezone;
    private double freshSnow;
    private Double snowHeight;
    private Weather weather;
    private Precipitation prec;
    private Integer sunHours;
    private Double rainHours;
    private Temperature temperature;
    private Wind wind;
    private WindChill windchill;
    private SnowLine snowLine;
    private Astronomy astronomy;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Weather {
    private int state;
    private String text;
    private String icon;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Precipitation {
    private double sum;
    private int probability;
    private Double sumAsRain;
    private int classification;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Temperature {
    private int min;
    private int max;
    private Double avg;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Wind {
    private String unit;
    private String direction;
    private String text;
    private Double avg;
    private int min;
    private int max;
    private Gusts gusts;
    private boolean significationWind;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Gusts {
    private int value;
    private String text;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class WindChill {
    private int min;
    private int max;
    private Double avg;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class SnowLine {
    private Double avg;
    private Double min;
    private Double max;
    private String unit;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Astronomy {
    private String dawn;
    private String sunrise;
    private String suntransit;
    private String sunset;
    private String dusk;
    private String moonrise;
    private String moontransit;
    private String moonset;
    private int moonphase;
    private int moonzodiac;
  }
}
