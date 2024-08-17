package org.weather.connect.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherObservationHistoryModel {

  private String id;
  private String name;
  private String type;
  private int distance;
  private Coordinates coordinates;
  private List<History> history;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Coordinates {
    private double latitude;
    private double longitude;
    private Double elevation;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class History {
    private String summary;
    private List<Details> details;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Details {
    private String date;
    private Temperature temperature;
    private Wind wind;
    private Double pressure;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Temperature {
    private String unit;
    private Double avg;
    private Double min;
    private Double max;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Wind {
    private String unit;
    private String direction;
    private String text;
    private Double avg;
    private Double min;
    private Double max;
    private Gusts gusts;
    private boolean significationWind;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Gusts {
    private Double value;
    private String text;
  }
}



