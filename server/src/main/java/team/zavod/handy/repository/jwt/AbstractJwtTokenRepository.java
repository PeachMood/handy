package team.zavod.handy.repository.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import team.zavod.handy.configuration.ApplicationConfiguration;
import team.zavod.handy.model.entity.jwt.AbstractJwtToken;

/**
 * <p>Provides common functionality to manage JWT tokens.</p>
 */
@Repository
public abstract class AbstractJwtTokenRepository {
  protected final ApplicationConfiguration applicationConfiguration;    // Instance of ApplicationConfig

  /**
   * <p>Constructs new instance of <code>AbstractJwtTokenRepository</code> class.</p>
   *
   * @param applicationConfiguration Instance of ApplicationConfig.
   */
  protected AbstractJwtTokenRepository(ApplicationConfiguration applicationConfiguration) {
    this.applicationConfiguration = applicationConfiguration;
  }

  /**
   * <p>Generates JWT token.</p>
   *
   * @param request HttpServletRequest to use.
   * @return Generated JWT token.
   */
  public abstract AbstractJwtToken generateToken(HttpServletRequest request);

  /**
   * <p>Saves specified JWT access token, or deletes it if <code>null</code> is specified.</p>
   *
   * @param token JWT token to save, or null to delete.
   * @param request HttpServletRequest to use.
   * @param response HttpServletResponse to use.
   */
  public abstract void saveToken(AbstractJwtToken token, HttpServletRequest request, HttpServletResponse response);

  /**
   * <p>Loads JWT token.</p>
   *
   * @param request HTTP request to use.
   * @return Loaded JWT token,
   * or <code>null</code> if it doesn't exist.
   */
  public abstract AbstractJwtToken loadToken(HttpServletRequest request);

  /**
   * <p>Returns expiration time for this token based on the application configuration (in seconds).<./p>
   *
   * @return Expiration time for this token.
   */
  public abstract long getExpirationTime();

  /**
   * <p>Generates JWT token.</p>
   *
   * @return Generated JWT token.
   */
  protected SignedJWT generateJwtToken() {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      Object principal = Objects.nonNull(authentication) ? authentication.getPrincipal() : null;
      UserDetails userDetails = principal instanceof UserDetails ? (UserDetails) principal : null;
      if(Objects.isNull(userDetails)) {
        return null;
      }
      LocalDateTime now = LocalDateTime.now();
      LocalDateTime expirationTime = now.plusHours(getExpirationTime());
      JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
      JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
          .subject(userDetails.getUsername())
          .expirationTime(Date.from(expirationTime.atZone(ZoneId.systemDefault()).toInstant()))
          .notBeforeTime(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))
          .issueTime(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))
          .jwtID(UUID.randomUUID().toString().replace("-", ""))
          .claim("roles", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
          .build();
      SignedJWT signedJwt = new SignedJWT(header, claimsSet);
    try {
      signedJwt.sign(new MACSigner(this.applicationConfiguration.jwt().secret()));
      return signedJwt;
    } catch (JOSEException e) {
      throw new IllegalStateException("Error! Failed to create JWT", e);
    }
  }
}
