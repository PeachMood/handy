package team.zavod.handy.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * <p>Authentication failure handler which simply returns appropriate HTTP status.</p>
 */
public class HttpStatusReturningAuthenticationFailureHandler implements AuthenticationFailureHandler {
  protected final Log logger = LogFactory.getLog(getClass());    // For logging purposes

  /**
   * <p>Called when an authentication attempt fails.</p>
   *
   * @param request the request during which the authentication attempt occurred.
   * @param response the response.
   * @param exception the exception which was thrown to reject the authentication request.
   */
  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
    this.logger.debug("Sending 401 Unauthorized error");
    response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
  }
}
