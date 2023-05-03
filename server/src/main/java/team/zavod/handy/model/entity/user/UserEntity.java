package team.zavod.handy.model.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/** Represents single user. */
@Entity(name = "User")
@Table(name = "user")
public class UserEntity implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // Unique user identifier

  @Column(name = "name")
  private String username; // Unique username

  private String email; // User's e-mail address
  private String avatar; // Path to user's avatar

  @Column(name = "password_hash")
  private String password; // Hash of user's password

  @OneToOne private SettingsEntity settings; // Instance of user SettingsEntity

  @ManyToMany(fetch = FetchType.EAGER)
  private Set<RoleEntity> roles; // Set with user RoleEntity instances

  /** Constructs new instance of <code>UserEntity</code> class. */
  public UserEntity() {}

  /**
   * Constructs new instance of <code>UserEntity</code> class.
   *
   * @param id Unique user identifier.
   * @param username Unique user name.
   * @param email User's e-mail address.
   * @param avatar Path to user's avatar.
   * @param password Hash of user's password.
   * @param settings Instance of user SettingsEntity.
   * @param roles Set with user RoleEntity instances.
   */
  public UserEntity(
      Long id,
      String username,
      String email,
      String avatar,
      String password,
      SettingsEntity settings,
      Set<RoleEntity> roles) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.avatar = avatar;
    this.password = password;
    this.settings = settings;
    this.roles = roles;
  }

  /**
   * Getter for <code>id</code> field.
   *
   * @return Unique user identifier.
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Setter for <code>id</code> field.
   *
   * @param id Unique user identifier.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Getter for <code>username</code> field.
   *
   * @return Unique username.
   */
  @Override
  public String getUsername() {
    return this.username;
  }

  /**
   * Setter for <code>username</code> field.
   *
   * @param username Unique username.
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Getter for <code>email</code> field.
   *
   * @return User's e-mail address.
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Setter for <code>email</code> field.
   *
   * @param email User's e-mail address.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Getter for <code>avatar</code> field.
   *
   * @return Path to user's avatar.
   */
  public String getAvatar() {
    return this.avatar;
  }

  /**
   * Setter for <code>avatar</code> field.
   *
   * @param avatar Path to user's avatar.
   */
  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  /**
   * Getter for <code>password</code> field.
   *
   * @return Hash of user's password.
   */
  @Override
  public String getPassword() {
    return this.password;
  }

  /**
   * Setter for <code>password</code> field.
   *
   * @param password Hash of user's password.
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Getter for <code>settings</code> field.
   *
   * @return Instance of user SettingsEntity.
   */
  public SettingsEntity getSettings() {
    return this.settings;
  }

  /**
   * Setter for <code>settings</code> field.
   *
   * @param settings Instance of user SettingsEntity.
   */
  public void setSettings(SettingsEntity settings) {
    this.settings = settings;
  }

  /**
   * Getter for <code>roles</code> field.
   *
   * @return Set with user RoleEntity instances.
   */
  public Set<RoleEntity> getRoles() {
    return this.roles;
  }

  /**
   * Setter for <code>roles</code> field.
   *
   * @param roles Set with user RoleEntity instances.
   */
  public void setRoles(Set<RoleEntity> roles) {
    this.roles = roles;
  }

  /**
   * Returns the authorities granted to the user.
   *
   * @return User authorities.
   */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return getRoles();
  }

  /**
   * Indicates whether the user's account has expired.
   *
   * @return <code>true</code> if the user's account is valid.
   */
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  /**
   * Indicates whether the user is locked or unlocked.
   *
   * @return <code>true</code> if the user is not locked.
   */
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  /**
   * Indicates whether the user's credentials has expired.
   *
   * @return <code>true</code> if the user's credentials are valid.
   */
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /**
   * Indicates whether the user is enabled or disabled.
   *
   * @return <code>true</code> if the user is enabled.
   */
  @Override
  public boolean isEnabled() {
    return true;
  }
}
