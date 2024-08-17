package org.weather.connect.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * The type External call failure exception.
 */
@Getter
public class ExternalAPICallFailureException extends Exception {

  private final HttpStatus statusCode;

  /**
   * Instantiates a new External call failure exception.
   *
   * @param statusCode the status code
   * @param message the message
   */
  public ExternalAPICallFailureException(HttpStatus statusCode, String message) {
    super(message);
    this.statusCode = statusCode;
  }

  /**
   * Instantiates a new External call failure exception.
   *
   * @param statusCode the status code
   * @param message the message
   */
  public ExternalAPICallFailureException(int statusCode, String message) {
    this(HttpStatus.valueOf(statusCode), message);
  }

  /**
   * Instantiates a new External call failure exception.
   *
   * @param message the message
   */
  public ExternalAPICallFailureException(String message) {
    this(HttpStatus.BAD_GATEWAY, message);
  }

  /**
   * Instantiates a new External call failure exception.
   *
   * @param cause the cause
   */
  public ExternalAPICallFailureException(Throwable cause) {
    super(cause);
    this.statusCode = HttpStatus.BAD_GATEWAY;
  }

  /**
   * Instantiates a new External call failure exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public ExternalAPICallFailureException(String message, Throwable cause) {
    super(message, cause);
    this.statusCode = HttpStatus.BAD_GATEWAY;
  }
}
