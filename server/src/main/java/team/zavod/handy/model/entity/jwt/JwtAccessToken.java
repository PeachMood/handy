package team.zavod.handy.model.entity.jwt;

/**
 * <p>Represents JWT access token</p>
 */
public class JwtAccessToken extends AbstractJwtToken {
  private final String headerName;    // HTTP header name to use
  private final String contentKey;    // JSON content key to use

  /**
   * <p>Constructs new instance of <code>JwtAccessToken</code> class.</p>
   *
   * @param headerName   HTTP header name to use.
   * @param contentKey   JSON content key to use.
   * @param type Type of the token.
   * @param token        Value of the token.
   */
  public JwtAccessToken(String headerName, String contentKey, String type, String token) {
    super(type, token);
    this.headerName = headerName;
    this.contentKey = contentKey;
  }

  /**
   * <p>Getter for <code>headerName</code> field.</p>
   *
   * @return HTTP header name to use.
   */
  public String getHeaderName() {
    return this.headerName;
  }

  /**
   * <p>Getter for <code>contentKey</code> field.</p>
   *
   * @return JSON content key to use.
   */
  public String getContentKey() {
    return this.contentKey;
  }
}
