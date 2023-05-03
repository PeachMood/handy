package team.zavod.handy.security.jwt;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/** Represents authentication token. */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {
  private final Object principal; // Represents abstract notion of the user's principal
  private Object credentials; // Represents abstract notion of the user's credentials

  /**
   * Constructs new instance of <code>JwtAuthenticationToken</code> class.
   *
   * @param principal Represents abstract notion of the user's principal.
   * @param credentials Represents abstract notion of the user's credentials.
   */
  public JwtAuthenticationToken(Object principal, Object credentials) {
    this(principal, credentials, null);
    setAuthenticated(false);
  }

  /**
   * Constructs new instance of <code>JwtAuthenticationToken</code> class.
   *
   * @param principal Represents abstract notion of the user's principal.
   * @param credentials Represents abstract notion of the user's credentials.
   * @param authorities Represents user authorities.
   */
  public JwtAuthenticationToken(
      Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.principal = principal;
    this.credentials = credentials;
    setAuthenticated(true);
  }

  /**
   * Factory method to initialize unauthenticated JWT authentication token.
   *
   * @param principal Represents abstract notion of the user's principal.
   * @param credentials Represents abstract notion of the user's credentials.
   * @return New instance of the <code>JwtAuthenticationToken</code> class.
   */
  public static JwtAuthenticationToken unauthenticated(Object principal, Object credentials) {
    return new JwtAuthenticationToken(principal, credentials);
  }

  /**
   * Factory method to initialize authenticated JWT authentication token.
   *
   * @param principal Represents abstract notion of the user's principal.
   * @param credentials Represents abstract notion of the user's credentials.
   * @param authorities Represents user authorities.
   * @return New instance of the <code>JwtAuthenticationToken</code> class.
   */
  public static JwtAuthenticationToken authenticated(
      Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
    return new JwtAuthenticationToken(principal, credentials, authorities);
  }

  /**
   * Getter for <code>principal</code> field.
   *
   * @return Abstract notion of the user's principal.
   */
  @Override
  public Object getPrincipal() {
    return this.principal;
  }

  /**
   * Getter for <code>credentials</code> field.
   *
   * @return Abstract notion of the user's credentials.
   */
  @Override
  public Object getCredentials() {
    return this.credentials;
  }

  /** Clears user's credentials. */
  @Override
  public void eraseCredentials() {
    super.eraseCredentials();
    this.credentials = null;
  }
}
