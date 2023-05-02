package team.zavod.handy.model.entity.jwt;

/**
 * <p>Represents abstract JWT token.</p>
 */
public class AbstractJwtToken {
  private final String type;    // Type of the token
  private final String token;    // Value of the token

  /**
   * <p>Constructs new instance of <code>AbstractJwtToken</code> class.</p>
   *
   * @param type Type of the token.
   * @param token Value of the token.
   */
  protected AbstractJwtToken(String type, String token) {
    this.type = type;
    this.token = token;
  }

  /**
   * <p>Getter for <code>type</code> field.</p>
   *
   * @return Type of the token.
   */
  public String getType() {
    return this.type;
  }

  /**
   * <p>Getter for <code>token</code> field.</p>
   *
   * @return Value of the token.
   */
  public String getToken() {
    return this.token;
  }
}
