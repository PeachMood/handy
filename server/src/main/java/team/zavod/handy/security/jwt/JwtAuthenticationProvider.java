package team.zavod.handy.security.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.proc.BadJOSEException;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.SignedJWT;
import com.nimbusds.jwt.proc.DefaultJWTClaimsVerifier;
import com.nimbusds.jwt.proc.JWTClaimsSetVerifier;
import java.text.ParseException;
import java.util.Objects;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import team.zavod.handy.configuration.ApplicationConfiguration;

/** An authentication provider implementation that retrieves user details from a JWT token. */
public class JwtAuthenticationProvider implements AuthenticationProvider {
  protected final Log logger; // For logging purposes
  private final ApplicationConfiguration applicationConfiguration; // Instance of ApplicationConfig
  private final UserDetailsService userDetailsService; // Instance of UserDetailsService

  /**
   * Constructs new instance of <code>JwtAuthenticationProvider</code> class.
   *
   * @param applicationConfiguration Instance of ApplicationConfig.
   * @param userDetailsService Instance of UserDetailsService.
   */
  public JwtAuthenticationProvider(
      ApplicationConfiguration applicationConfiguration, UserDetailsService userDetailsService) {
    this.logger = LogFactory.getLog(getClass());
    this.applicationConfiguration = applicationConfiguration;
    this.userDetailsService = userDetailsService;
  }

  /**
   * Attempts to authenticate the past authentication object, returning a fully populated
   * authentication object.
   *
   * @param authentication the authentication request object.
   * @return Fully authenticated object.
   * @throws AuthenticationException If authentication fails.
   */
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
    String username = determineUsername(jwtAuthenticationToken);
    try {
      UserDetails userDetails = retrieveUser(username);
      additionalAuthenticationChecks(jwtAuthenticationToken);
      return createSuccessAuthentication(userDetails, jwtAuthenticationToken, userDetails);
    } catch (UsernameNotFoundException e) {
      this.logger.debug("Failed to find user '" + username + "'");
      throw new BadCredentialsException("Bad credentials");
    }
  }

  /**
   * Returns <code>true</code> if this authentication provider supports the indicated authentication
   * object.
   *
   * @param authentication Authentication object to be checked.
   * @return <code>true</code> if this authentication provider supports the indicated authentication
   *     object, or <code>false</code> otherwise.
   */
  @Override
  public boolean supports(Class<?> authentication) {
    return JwtAuthenticationToken.class.isAssignableFrom(authentication);
  }

  /* Tries to determine username from JWT token */
  private String determineUsername(JwtAuthenticationToken authentication) {
    return Objects.nonNull(authentication.getPrincipal()) ? authentication.getName() : "";
  }

  /* Tries to retrieve user from UserDetailsService */
  private UserDetails retrieveUser(String username) throws AuthenticationException {
    UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
    if (Objects.isNull(userDetails)) {
      throw new InternalAuthenticationServiceException(
          "UserDetailsService returned null, which is an interface contract violation");
    }
    return userDetails;
  }

  /* Performs additional checks for user authentication */
  private void additionalAuthenticationChecks(JwtAuthenticationToken authentication)
      throws AuthenticationException {
    if (Objects.isNull(authentication.getCredentials())) {
      this.logger.debug("Failed to authenticate since no credentials provided");
      throw new BadCredentialsException("Bad credentials");
    }
    try {
      SignedJWT signedJwt = SignedJWT.parse(authentication.getCredentials().toString());
      if (!signedJwt.verify(
          new MACVerifier(this.applicationConfiguration.jwt().secret().getBytes()))) {
        this.logger.debug("Failed to authenticate since the JWT signature was invalid");
        throw new BadCredentialsException("Bad credentials");
      }
      JWTClaimsSetVerifier<SecurityContext> claimsSetVerifier =
          new DefaultJWTClaimsVerifier<>(null, null);
      claimsSetVerifier.verify(signedJwt.getJWTClaimsSet(), null);
    } catch (ParseException e) {
      this.logger.debug("Failed to authenticate since the JWT was invalid");
      throw new BadCredentialsException("Bad credentials");
    } catch (BadJOSEException e) {
      this.logger.debug("Failed to authenticate since JWT claims set was invalid");
      throw new BadCredentialsException("Bad credentials");
    } catch (JOSEException e) {
      throw new IllegalStateException("Error! Failed to verify JWT", e);
    }
  }

  /* Creates authentication object for successfully authenticated user */
  private Authentication createSuccessAuthentication(
      Object principal, Authentication authentication, UserDetails userDetails) {
    JwtAuthenticationToken jwtAuthenticationToken =
        JwtAuthenticationToken.authenticated(
            principal, authentication.getCredentials(), userDetails.getAuthorities());
    jwtAuthenticationToken.setDetails(authentication.getDetails());
    this.logger.debug("Authenticated user");
    return jwtAuthenticationToken;
  }
}
