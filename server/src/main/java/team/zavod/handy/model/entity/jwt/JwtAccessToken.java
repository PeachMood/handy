package team.zavod.handy.model.entity.jwt;

/** Represents JWT access token */
public class JwtAccessToken extends AbstractJwtToken {
  private final String headerName; // HTTP header name to use
  private final String contentKey; // JSON content key to use

  /**
   * Constructs new instance of <code>JwtAccessToken</code> class.
   *
   * @param headerName HTTP header name to use.
   * @param contentKey JSON content key to use.
   * @param type Type of the token.
   * @param token Value of the token.
   */
  public JwtAccessToken(String headerName, String contentKey, String type, String token) {
    super(type, token);
    this.headerName = headerName;
    this.contentKey = contentKey;
  }

  /**
   * Getter for <code>headerName</code> field.
   *
   * @return HTTP header name to use.
   */
  public String getHeaderName() {
    return this.headerName;
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
