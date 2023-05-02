package team.zavod.handy.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>Stores application configuration.</p>
 *
 * @param domain Domain name of the service.
 * @param cors Cors configuration.
 * @param jwt JWT configuration.
 */
@ConfigurationProperties(prefix = "application.config")
public record ApplicationConfiguration(String domain, Cors cors, Jwt jwt) {
  /**
   * <p>Stores cors configuration.</p>
   *
   * @param allowedOrigins List of allowed origins.
   */
  public record Cors(String[] allowedOrigins) {
  }

  /**
   * <p>Stores JWT configuration.</p>
   *
   * @param accessTokenExpirationTime Expiration time for access token (in minutes).
   * @param refreshTokenExpirationTime Expiration time for refresh token (in days).
   * @param secret Encryption key.
   */
  public record Jwt(long accessTokenExpirationTime, long refreshTokenExpirationTime, String secret) {
  }
}
