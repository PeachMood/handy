package team.zavod.handy.model.entity.jwt;

/** Represents abstract JWT token. */
public class AbstractJwtToken {
  private final String type; // Type of the token
  private final String token; // Value of the token

  /**
   * Constructs new instance of <code>AbstractJwtToken</code> class.
   *
   * @param type Type of the token.
   * @param token Value of the token.
   */
  protected AbstractJwtToken(String type, String token) {
    this.type = type;
    this.token = token;
  }

  /**
   * Getter for <code>type</code> field.
   *
   * @return Type of the token.
   */
  public String getType() {
    return this.type;
  }

  /**
   * Getter for <code>token</code> field.
   *
   * @return Value of the token.
   */
  public String getToken() {
    return this.token;
  }
}
