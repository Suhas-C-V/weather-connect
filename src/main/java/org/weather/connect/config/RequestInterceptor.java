package org.weather.connect.config;

import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;

public class RequestInterceptor implements Interceptor {

  public static final String X_HOST = "x-rapidapi-host";

  public static final String X_KEY = "x-rapidapi-key";

  private final String host;
  private final String key;

  public RequestInterceptor(String host, String key) {
    this.host = host;
    this.key = key;
  }

  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {
    return chain.proceed(
        chain
            .request()
            .newBuilder()
            .header(X_HOST, host)
            .header(X_KEY, key)
            .build());
  }
}
