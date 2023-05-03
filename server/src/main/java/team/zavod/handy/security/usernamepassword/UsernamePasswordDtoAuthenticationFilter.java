package team.zavod.handy.security.usernamepassword;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import team.zavod.handy.model.entity.usernamepassword.UsernamePasswordToken;

/** Handles requests with username and password as authentication credentials. */
public class UsernamePasswordDtoAuthenticationFilter
    extends AbstractAuthenticationProcessingFilter {
  /** Constructs new instance of <code>UsernamePasswordDtoAuthenticationFilter</code> class. */
  public UsernamePasswordDtoAuthenticationFilter() {
    super(new AntPathRequestMatcher("/api/auth/login"));
  }

  /**
   * Constructs new instance of <code>UsernamePasswordDtoAuthenticationFilter</code> class.
   *
   * @param authenticationManager AuthenticationManager used to authenticate an authentication
   *     object.
   */
  public UsernamePasswordDtoAuthenticationFilter(AuthenticationManager authenticationManager) {
    super(new AntPathRequestMatcher("/api/auth/login"), authenticationManager);
  }

  /**
   * Performs actual authentication.
   *
   * @param request from which to extract parameters and perform the authentication
   * @param response the response, which may be needed if the implementation has to do a redirect as
   *     part of a multi-stage authentication process (such as OIDC).
   * @return The authenticated user token, or <code>null</code> if authentication is incomplete.
   * @throws AuthenticationException If authentication fails.
   */
  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    UsernamePasswordToken usernamePasswordToken = obtainToken(request);
    String username =
        Objects.nonNull(usernamePasswordToken) ? usernamePasswordToken.username() : "";
    String password =
        Objects.nonNull(usernamePasswordToken) ? usernamePasswordToken.password() : "";
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
        UsernamePasswordAuthenticationToken.unauthenticated(username, password);
    setDetails(request, usernamePasswordAuthenticationToken);
    return this.getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
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

  /* Tries to obtain username and password from HTTP request */
  private UsernamePasswordToken obtainToken(HttpServletRequest request) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(request.getReader(), UsernamePasswordToken.class);
    } catch (IOException e) {
      return null;
    }
  }

  /* Sets the authentication request details property */
  private void setDetails(
      HttpServletRequest request,
      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
    usernamePasswordAuthenticationToken.setDetails(
        this.authenticationDetailsSource.buildDetails(request));
  }
}
