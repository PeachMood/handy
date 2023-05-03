package team.zavod.handy.repository.jwt;

import com.nimbusds.jwt.SignedJWT;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.util.WebUtils;
import team.zavod.handy.configuration.ApplicationConfiguration;
import team.zavod.handy.model.entity.jwt.AbstractJwtToken;
import team.zavod.handy.model.entity.jwt.JwtRefreshToken;

/** Provides functionality to manage JWT access tokens. */
@Repository
public class JwtRefreshTokenRepository extends AbstractJwtTokenRepository {
  private static final String COOKIE_NAME = "refresh_token"; // HTTP cookie name to use
  private static final String CONTENT_KEY = "refresh_token"; // JSON content key to use
  private static final String TYPE = "Bearer"; // Type of the token

  /**
   * Constructs new instance of <code>JwtRefreshTokenRepository</code> class.
   *
   * @param applicationConfiguration Instance of ApplicationConfig.
   */
  @Autowired
  public JwtRefreshTokenRepository(ApplicationConfiguration applicationConfiguration) {
    super(applicationConfiguration);
  }

  /**
   * Generates JWT refresh token.
   *
   * @param request HttpServletRequest to use.
   * @return Generated JWT refresh token.
   */
  @Override
  public JwtRefreshToken generateToken(HttpServletRequest request) {
    SignedJWT signedJwt = generateJwtToken();
    return Objects.nonNull(signedJwt)
        ? new JwtRefreshToken(COOKIE_NAME, CONTENT_KEY, TYPE, signedJwt.serialize())
        : null;
  }

  /**
   * Saves specified JWT refresh token, or deletes it if <code>null</code> is specified.
   *
   * @param token JWT refresh token to save, or null to delete.
   * @param request HttpServletRequest to use.
   * @param response HttpServletResponse to use.
   */
  @Override
  public void saveToken(
      AbstractJwtToken token, HttpServletRequest request, HttpServletResponse response) {
    Cookie cookie =
        Objects.nonNull(token) ? createJwtRefreshTokenCookie(token) : deleteJwtRefreshTokenCookie();
    if (Objects.nonNull(cookie)) {
      response.addCookie(cookie);
    }
  }

  /**
   * Loads JWT refresh token.
   *
   * @param request HTTP request to use.
   * @return Loaded JWT refresh token, or <code>null</code> if it doesn't exist.
   */
  @Override
  public JwtRefreshToken loadToken(HttpServletRequest request) {
    Cookie cookie = WebUtils.getCookie(request, COOKIE_NAME);
    if (Objects.isNull(cookie)) {
      return null;
    }
    return new JwtRefreshToken(COOKIE_NAME, CONTENT_KEY, TYPE, cookie.getValue());
  }

  /**
   * Returns expiration time for JWT refresh token based on the application configuration (in
   * seconds).<./p>
   *
   * @return Expiration time for JWT refresh token.
   */
  @Override
  public long getExpirationTime() {
    return TimeUnit.DAYS.toSeconds(
        this.applicationConfiguration.jwt().refreshTokenExpirationTime());
  }

  /* Creates JWT refresh token cookie */
  private Cookie createJwtRefreshTokenCookie(AbstractJwtToken abstractToken) {
    JwtRefreshToken refreshToken =
        abstractToken instanceof JwtRefreshToken ? (JwtRefreshToken) abstractToken : null;
    if (Objects.isNull(refreshToken)) {
      return null;
    }
    Cookie cookie = new Cookie(COOKIE_NAME, refreshToken.getToken());
    cookie.setDomain(this.applicationConfiguration.domain());
    cookie.setMaxAge((int) getExpirationTime());
    cookie.setPath("/api/auth");
    cookie.setHttpOnly(true);
    return cookie;
  }

  /* Deletes JWT refresh token cookie */
  private Cookie deleteJwtRefreshTokenCookie() {
    Cookie cookie = new Cookie(COOKIE_NAME, null);
    cookie.setDomain(this.applicationConfiguration.domain());
    cookie.setMaxAge(0);
    cookie.setPath("/api/auth");
    cookie.setHttpOnly(true);
    return cookie;
  }
}
