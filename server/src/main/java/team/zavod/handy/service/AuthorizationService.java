package team.zavod.handy.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.zavod.handy.model.entity.jwt.JwtAccessToken;
import team.zavod.handy.model.entity.jwt.JwtRefreshToken;
import team.zavod.handy.repository.jwt.JwtAccessTokenRepository;
import team.zavod.handy.repository.jwt.JwtRefreshTokenRepository;

/**
 * <p>Implements complex logic related to authorization.</p>
 */
@Service
public class AuthorizationService {
  private final JwtAccessTokenRepository jwtAccessTokenRepository;    // Instance of JwtAccessTokenRepository
  private final JwtRefreshTokenRepository jwtRefreshTokenRepository;    // Instance of JwtRefreshTokenRepository

  /**
   * <p>Constructs new instance of <code>AuthorizationService</code> class.</p>
   *
   * @param jwtAccessTokenRepository Instance of JwtAccessTokenRepository.
   * @param jwtRefreshTokenRepository Instance of JwtRefreshTokenRepository.
   */
  @Autowired
  public AuthorizationService(JwtAccessTokenRepository jwtAccessTokenRepository, JwtRefreshTokenRepository jwtRefreshTokenRepository) {
    this.jwtAccessTokenRepository = jwtAccessTokenRepository;
    this.jwtRefreshTokenRepository = jwtRefreshTokenRepository;
  }

  /**
   * <p>Generates JWT access token.</p>
   *
   * @param request HttpServletRequest to use.
   * @return Generated JWT access token.
   */
  public JwtAccessToken generateAccessToken(HttpServletRequest request) {
    return this.jwtAccessTokenRepository.generateToken(request);
  }

  /**
   * <p>Generates JWT refresh token.</p>
   *
   * @param request HttpServletRequest to use.
   * @return Generated JWT refresh token.
   */
  public JwtRefreshToken generateRefreshToken(HttpServletRequest request) {
    return this.jwtRefreshTokenRepository.generateToken(request);
  }

  /**
   * <p>Saves specified JWT access token, or deletes it if <code>null</code> is specified.</p>
   *
   * @param token JWT token to save, or null to delete.
   * @param request HttpServletRequest to use.
   * @param response HttpServletResponse to use.
   */
  public void saveAccessToken(JwtAccessToken token, HttpServletRequest request, HttpServletResponse response) {
    this.jwtAccessTokenRepository.saveToken(token, request, response);
  }

  /**
   * <p>Saves specified JWT refresh token, or deletes it if <code>null</code> is specified.</p>
   *
   * @param token JWT refresh token to save, or null to delete.
   * @param request HttpServletRequest to use.
   * @param response HttpServletResponse to use.
   */
  public void saveRefreshToken(JwtRefreshToken token, HttpServletRequest request, HttpServletResponse response) {
    this.jwtRefreshTokenRepository.saveToken(token, request, response);
  }

  /**
   * <p>Loads JWT access token.</p>
   *
   * @param request HTTP request to use.
   * @return Loaded JWT access token,
   * or <code>null</code> if it doesn't exist.
   */
  public JwtAccessToken loadAccessToken(HttpServletRequest request) {
    return this.jwtAccessTokenRepository.loadToken(request);
  }

  /**
   * <p>Loads JWT refresh token.</p>
   *
   * @param request HTTP request to use.
   * @return Loaded JWT refresh token,
   * or <code>null</code> if it doesn't exist.
   */
  public JwtRefreshToken loadRefreshToken(HttpServletRequest request) {
    return this.jwtRefreshTokenRepository.loadToken(request);
  }

  /**
   * <p>Returns expiration time for JWT access token based on the application configuration (in seconds).<./p>
   *
   * @return Expiration time for JWT access token.
   */
  public long getAccessTokenExpirationTime() {
    return this.jwtAccessTokenRepository.getExpirationTime();
  }

  /**
   * <p>Returns expiration time for JWT refresh token based on the application configuration (in seconds).<./p>
   *
   * @return Expiration time for JWT refresh token.
   */
  public long getRefreshTokenExpirationTime() {
    return this.jwtRefreshTokenRepository.getExpirationTime();
  }
}
