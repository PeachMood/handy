package team.zavod.handy.repository.jwt;

import com.nimbusds.jwt.SignedJWT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import team.zavod.handy.configuration.ApplicationConfiguration;
import team.zavod.handy.model.entity.jwt.AbstractJwtToken;
import team.zavod.handy.model.entity.jwt.JwtAccessToken;

/**
 * <p>Provides functionality to manage JWT access tokens.</p>
 */
@Repository
public class JwtAccessTokenRepository extends AbstractJwtTokenRepository {
  private static final String HEADER_NAME = HttpHeaders.AUTHORIZATION;    // HTTP header name to use
  private static final String CONTENT_KEY = "access_token";    // JSON content key to use
  private static final String TYPE = "Bearer";    // Type of the token

  /**
   * <p>Constructs new instance of <code>JwtAccessTokenRepository</code> class.</p>
   *
   * @param applicationConfiguration Instance of ApplicationConfig.
   */
  @Autowired
  public JwtAccessTokenRepository(ApplicationConfiguration applicationConfiguration) {
    super(applicationConfiguration);
  }

  /**
   * <p>Generates JWT access token.</p>
   *
   * @param request HttpServletRequest to use.
   * @return Generated JWT access token.
   */
  @Override
  public JwtAccessToken generateToken(HttpServletRequest request) {
    SignedJWT signedJwt = generateJwtToken();
    return Objects.nonNull(signedJwt) ? new JwtAccessToken(HEADER_NAME, CONTENT_KEY, TYPE, signedJwt.serialize()) : null;
  }

  /**
   * <p>Saves specified JWT access token, or deletes it if <code>null</code> is specified.</p>
   *
   * @param token JWT token to save, or null to delete.
   * @param request HttpServletRequest to use.
   * @param response HttpServletResponse to use.
   */
  @Override
  public void saveToken(AbstractJwtToken token, HttpServletRequest request, HttpServletResponse response) {
  }

  /**
   * <p>Loads JWT access token.</p>
   *
   * @param request HTTP request to use.
   * @return Loaded JWT access token,
   * or <code>null</code> if it doesn't exist.
   */
  @Override
  public JwtAccessToken loadToken(HttpServletRequest request) {
    String token = request.getHeader(HEADER_NAME);
    if(Objects.isNull(token) || !token.startsWith(TYPE)) {
      return null;
    }
    return new JwtAccessToken(HEADER_NAME, CONTENT_KEY, TYPE, token.substring(TYPE.length() + 1));
  }

  /**
   * <p>Returns expiration time for JWT access token based on the application configuration (in seconds).<./p>
   *
   * @return Expiration time for JWT access token.
   */
  @Override
  public long getExpirationTime() {
    return TimeUnit.MINUTES.toSeconds(this.applicationConfiguration.jwt().accessTokenExpirationTime());
  }
}
