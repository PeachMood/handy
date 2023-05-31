package team.zavod.handy.model.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDateTime;
import java.util.Random;

/** Represents single verification token */
@Entity(name = "VerificationToken")
@Table(name = "verification_token")
public class VerificationTokenEntity {
  @Transient private static final int TOKEN_LENGTH = 32; // Length of the verification token

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // Unique verification token identifier

  private String token; // VerificationToken

  @Column(name = "creation_date")
  private LocalDateTime creationDate; // Date of token creation

  @ManyToOne private UserEntity user; // Instance of UserEntity

  /** Creates instance of <code>VerificationTokenEntity</code> class. */
  public VerificationTokenEntity() {
    this.token = generateRandomString(TOKEN_LENGTH);
    this.creationDate = LocalDateTime.now();
  }

  /**
   * Creates instance of <code>VerificationTokenEntity</code> class.
   *
   * @param id Unique verification token identifier.
   * @param user Instance of UserEntity.
   */
  public VerificationTokenEntity(Long id, UserEntity user) {
    this(id, LocalDateTime.now(), user);
  }

  /**
   * Creates new instance of <code>VerificationTokenEntity</code> class.
   *
   * @param id Unique verification token identifier.
   * @param creationDate Date of token creation.
   * @param user Instance of UserEntity.
   */
  public VerificationTokenEntity(Long id, LocalDateTime creationDate, UserEntity user) {
    this();
    this.id = id;
    this.creationDate = creationDate;
    this.user = user;
  }

  /**
   * Creates new instance of <code>VerificationTokenEntity</code> class.
   *
   * @param id Unique verification token identifier.
   * @param token Verification token
   * @param creationDate Date of token creation.
   * @param user Instance of UserEntity.
   */
  public VerificationTokenEntity(
      Long id, String token, LocalDateTime creationDate, UserEntity user) {
    this.id = id;
    this.token = token;
    this.creationDate = creationDate;
    this.user = user;
  }

  /**
   * Getter for <code>id</code> field.
   *
   * @return Unique verification token identifier.
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Setter for <code>id</code> field.
   *
   * @param id Unique verification token identifier.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Getter for <code>token</code> field.
   *
   * @return Verification token.
   */
  public String getToken() {
    return this.token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  /**
   * Getter for <code>creationDate</code> field.
   *
   * @return Date of token creation.
   */
  public LocalDateTime getCreationDate() {
    return this.creationDate;
  }

  /**
   * Setter for <code>creationDate</code> field.
   *
   * @param creationDate Date of token creation.
   */
  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  /**
   * Getter for <code>user</code> field.
   *
   * @return Instance of UserEntity.
   */
  public UserEntity getUser() {
    return this.user;
  }

  /**
   * Setter for <code>user</code> field.
   *
   * @param user Instance of UserEntity.
   */
  public void setUser(UserEntity user) {
    this.user = user;
  }

  /* Generates random string of the specified length */
  @SuppressWarnings("SameParameterValue")
  private String generateRandomString(int length) {
    Random random = new Random();
    return random
        .ints(0x20, 0x80)
        .filter(Character::isLetterOrDigit)
        .limit(length)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }
}
