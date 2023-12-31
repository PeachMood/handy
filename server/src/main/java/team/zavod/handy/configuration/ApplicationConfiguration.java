package team.zavod.handy.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Stores application configuration.
 *
 * @param domain Domain name of the service.
 * @param cors Cors configuration.
 * @param jwt JWT configuration.
 * @param verification Verification configuration.
 */
@ConfigurationProperties(prefix = "application.config")
public record ApplicationConfiguration(
    String domain, Cors cors, Jwt jwt, Verification verification) {
  /**
   * Stores cors configuration.
   *
   * @param allowedOrigins List of allowed origins.
   */
  public record Cors(String[] allowedOrigins) {}

  /**
   * Stores JWT configuration.
   *
   * @param accessTokenExpirationTime Expiration time for access token (in minutes).
   * @param refreshTokenExpirationTime Expiration time for refresh token (in days).
   * @param secret Encryption key.
   */
  public record Jwt(
      long accessTokenExpirationTime, long refreshTokenExpirationTime, String secret) {}

  /**
   * Stores verification token configuration.
   *
   * @param tokenExpirationTime Expiration time for verification token (in hours).
   * @param email Email address of the service.
   */
  public record Verification(long tokenExpirationTime, String email) {}
}
