package team.zavod.handy.entity.user;

import java.nio.file.Path;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <p>Represents single user.</p>
 */
@Entity
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;    // Unique user identifier
  private String name;    // Unique username
  private String email;    // User's e-mail address
  private String avatar;    // Path to user's avatar
  @Column(name = "password_hash")
  private String passwordHash;    // Hash of user's password
  @OneToOne
  private SettingsEntity settings;    // Instance of user SettingsEntity

  /**
   * <p>Constructs new instance of <code>UserEntity</code> class.</p>
   */
  protected UserEntity() {
  }

  /**
   * <p>Constructs new instance of <code>UserEntity</code> class.</p>
   *
   * @param id Unique user identifier.
   * @param name Unique user name.
   * @param email User's e-mail address.
   * @param avatar Path to user's avatar.
   * @param passwordHash Hash of user's password.
   * @param settings Instance of user SettingsEntity.
   */
  public UserEntity(Long id,
      String name,
      String email,
      String avatar,
      String passwordHash,
      SettingsEntity settings) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.avatar = avatar;
    this.passwordHash = passwordHash;
    this.settings = settings;
  }

  /**
   * <p>Constructs new instance of <code>UserEntity</code> class.</p>
   *
   * @param id Unique user identifier.
   * @param name Unique user name.
   * @param email User's e-mail address.
   * @param avatar Path to user's avatar.
   * @param passwordHash Hash of user's password.
   * @param settings Instance of user SettingsEntity.
   */
  public UserEntity(Long id,
      String name,
      String email,
      Path avatar,
      String passwordHash,
      SettingsEntity settings) {
    this(id,
        name,
        email,
        avatar.toString(),
        passwordHash,
        settings);
  }

  /**
   * <p>Getter for <code>id</code> field.</p>
   *
   * @return Unique user identifier.
   */
  public Long getId() {
    return this.id;
  }

  /**
   * <p>Setter for <code>id</code> field.</p>
   *
   * @param id Unique user identifier.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * <p>Getter for <code>name</code> field.</p>
   *
   * @return Unique username.
   */
  public String getName() {
    return this.name;
  }

  /**
   * <p>Setter for <code>name</code> field.</p>
   *
   * @param name Unique username.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * <p>Getter for <code>email</code> field.</p>
   *
   * @return User's e-mail address.
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * <p>Setter for <code>email</code> field.</p>
   *
   * @param email User's e-mail address.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * <p>Getter for <code>avatar</code> field.</p>
   *
   * @return Path to user's avatar.
   */
  public String getAvatar() {
    return this.avatar;
  }

  /**
   * <p>Setter for <code>avatar</code> field.</p>
   *
   * @param avatar Path to user's avatar.
   */
  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  /**
   * <p>Setter for <code>avatar</code> field.</p>
   *
   * @param avatar Path to user's avatar.
   */
  public void setAvatar(Path avatar) {
    setAvatar(avatar.toString());
  }

  /**
   * <p>Getter for <code>passwordHash</code> field.</p>
   *
   * @return Hash of user's password.
   */
  public String getPasswordHash() {
    return this.passwordHash;
  }

  /**
   * <p>Setter for <code>passwordHash</code> field.</p>
   *
   * @param passwordHash Hash of user's password.
   */
  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  /**
   * <p>Getter for <code>settings</code> field.</p>
   *
   * @return Instance of user SettingsEntity.
   */
  public SettingsEntity getSettings() {
    return this.settings;
  }

  /**
   * <p>Setter for <code>settings</code> field.</p>
   *
   * @param settings Instance of user SettingsEntity.
   */
  public void setSettings(SettingsEntity settings) {
    this.settings = settings;
  }
}
