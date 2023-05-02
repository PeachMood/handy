package team.zavod.handy.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * <p>Authentication success handler which simply returns appropriate HTTP status.</p>
 */
public class HttpStatusReturningAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
  protected final Log logger = LogFactory.getLog(getClass());    // For logging purposes

  /**
   * <p>Called when a user has been successfully authenticated.</p>
   *
   * @param request the request which caused the successful authentication
   * @param response the response
   * @param authentication the Authentication object which was created during the authentication process.
   */
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    this.logger.debug("Sending 200 OK status");
    response.setStatus(HttpStatus.OK.value());
  }
}
