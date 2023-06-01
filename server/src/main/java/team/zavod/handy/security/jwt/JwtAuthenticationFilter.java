package team.zavod.handy.security.jwt;

import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import team.zavod.handy.model.entity.jwt.AbstractJwtToken;
import team.zavod.handy.repository.jwt.JwtAccessTokenRepository;
import team.zavod.handy.repository.jwt.JwtRefreshTokenRepository;

/** Handles requests with JWT tokens as authentication credentials. */
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
  private final JwtAccessTokenRepository
      jwtAccessTokenRepository; // Instance of JwtAccessTokenRepository
  private final JwtRefreshTokenRepository
      jwtRefreshTokenRepository; // Instance of JwtRefreshTokenRepository

  /**
   * Constructs new instance of <code>JwtAuthenticationFilter</code> class.
   *
   * @param jwtAccessTokenRepository Instance of JwtAccessTokenRepository.
   * @param jwtRefreshTokenRepository Instance of JwtRefreshTokenRepository.
   */
  public JwtAuthenticationFilter(
      JwtAccessTokenRepository jwtAccessTokenRepository,
      JwtRefreshTokenRepository jwtRefreshTokenRepository) {
    super(
        new OrRequestMatcher(
            new NegatedRequestMatcher(new AntPathRequestMatcher("/api/auth/**")),
            new AntPathRequestMatcher("/api/auth/refresh-token")));
    this.jwtAccessTokenRepository = jwtAccessTokenRepository;
    this.jwtRefreshTokenRepository = jwtRefreshTokenRepository;
  }

  /**
   * Constructs new instance of <code>JwtAuthenticationFilter</code> class.
   *
   * @param authenticationManager AuthenticationManager used to authenticate an authentication
   *     object.
   * @param jwtAccessTokenRepository Instance of JwtAccessTokenRepository.
   * @param jwtRefreshTokenRepository Instance of JwtRefreshTokenRepository.
   */
  public JwtAuthenticationFilter(
      AuthenticationManager authenticationManager,
      JwtAccessTokenRepository jwtAccessTokenRepository,
      JwtRefreshTokenRepository jwtRefreshTokenRepository) {
    super(
        new OrRequestMatcher(
            new NegatedRequestMatcher(new AntPathRequestMatcher("/api/auth/**")),
            new AntPathRequestMatcher("/api/auth/refresh-token")),
        authenticationManager);
    this.jwtAccessTokenRepository = jwtAccessTokenRepository;
    this.jwtRefreshTokenRepository = jwtRefreshTokenRepository;
  }

  /**
   * Performs actual authentication.
   *
   * @param request from which to extract parameters and perform the authentication
   * @param response the response, which may be needed if the implementation has to do a redirect as
   *     part of a multi-stage authentication process (such as OpenID).
   * @return The authenticated user token, or <code>null</code> if authentication is incomplete.
   * @throws AuthenticationException If authentication fails.
   */
  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    AbstractJwtToken abstractJwtToken =
        request.getServletPath().equals("/api/auth/refresh-token")
            ? this.jwtRefreshTokenRepository.loadToken(request)
            : this.jwtAccessTokenRepository.loadToken(request);
    String token = Objects.nonNull(abstractJwtToken) ? abstractJwtToken.getToken() : "";
    String username = Objects.nonNull(token) ? obtainUsername(token) : "";
    JwtAuthenticationToken jwtAuthenticationToken =
        JwtAuthenticationToken.unauthenticated(username, token);
    setDetails(request, jwtAuthenticationToken);
    return this.getAuthenticationManager().authenticate(jwtAuthenticationToken);
  }

  /**
   * Default handler for successful authentication.
   *
   * @param request HTTP request to use.
   * @param response HTTP response to use.
   * @param chain Filter chain to pass.
   * @param authentication the object returned from the attemptAuthentication method.
   * @throws IOException If method fails.
   * @throws ServletException If method fails.
   */
  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication authentication)
      throws IOException, ServletException {
    super.successfulAuthentication(request, response, chain, authentication);
    chain.doFilter(request, response);
  }

  /* Tries to obtain username from JWT token */
  private String obtainUsername(String token) {
    try {
      SignedJWT signedJwt = SignedJWT.parse(token);
      JWTClaimsSet claimsSet = signedJwt.getJWTClaimsSet();
      return claimsSet.getSubject();
    } catch (ParseException e) {
      return "";
    }
  }

  /* Sets the authentication request details property */
  private void setDetails(
      HttpServletRequest request, JwtAuthenticationToken jwtAuthenticationToken) {
    jwtAuthenticationToken.setDetails(this.authenticationDetailsSource.buildDetails(request));
  }
}
