package team.zavod.handy.model.entity.jwt;

/** Represents JWT refresh token. */
public class JwtRefreshToken extends AbstractJwtToken {
  private final String cookieName; // HTTP cookie name to use
  private final String contentKey; // JSON content key to use

  /**
   * Constructs new instance of <code>JwtRefreshToken</code> class.
   *
   * @param cookieName HTTP cookie name to use.
   * @param contentKey JSON content key to use.
   * @param type Type of the token.
   * @param token Value of the token.
   */
  public JwtRefreshToken(String cookieName, String contentKey, String type, String token) {
    super(type, token);
    this.cookieName = cookieName;
    this.contentKey = contentKey;
  }

  /**
   * Getter for <code>cookieName</code> field.
   *
   * @return HTTP cookie name to use.
   */
  public String getCookieName() {
    return this.cookieName;
  }

  /**
   * Getter for <code>contentKey</code> field.
   *
   * @return JSON content key to use.
   */
  public String getContentKey() {
    return this.contentKey;
  }
}
