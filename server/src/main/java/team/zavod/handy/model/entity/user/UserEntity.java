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

/**
 * <p>Represents single user.</p>
 */
@Entity(name = "User")
@Table(name = "user")
public class UserEntity implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;    // Unique user identifier
  @Column(name = "name")
  private String username;    // Unique username
  private String email;    // User's e-mail address
  private String avatar;    // Path to user's avatar
  @Column(name = "password_hash")
  private String password;    // Hash of user's password
  @OneToOne
  private SettingsEntity settings;    // Instance of user SettingsEntity
  @ManyToMany(fetch = FetchType.EAGER)
  private Set<RoleEntity> roles;    // Set with user RoleEntity instances

  /**
   * <p>Constructs new instance of <code>UserEntity</code> class.</p>
   */
  public UserEntity() {
  }

  /**
   * <p>Constructs new instance of <code>UserEntity</code> class.</p>
   *
   * @param id Unique user identifier.
   * @param username Unique user name.
   * @param email User's e-mail address.
   * @param avatar Path to user's avatar.
   * @param password Hash of user's password.
   * @param settings Instance of user SettingsEntity.
   * @param roles Set with user RoleEntity instances.
   */
  public UserEntity(Long id,
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
   * <p>Getter for <code>username</code> field.</p>
   *
   * @return Unique username.
   */
  @Override
  public String getUsername() {
    return this.username;
  }

  /**
   * <p>Setter for <code>username</code> field.</p>
   *
   * @param username Unique username.
   */
  public void setUsername(String username) {
    this.username = username;
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
   * <p>Getter for <code>password</code> field.</p>
   *
   * @return Hash of user's password.
   */
  @Override
  public String getPassword() {
    return this.password;
  }

  /**
   * <p>Setter for <code>password</code> field.</p>
   *
   * @param password Hash of user's password.
   */
  public void setPassword(String password) {
    this.password = password;
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

  /**
   * <p>Getter for <code>roles</code> field.</p>
   *
   * @return Set with user RoleEntity instances.
   */
  public Set<RoleEntity> getRoles() {
    return this.roles;
  }

  /**
   * <p>Setter for <code>roles</code> field.</p>
   *
   * @param roles Set with user RoleEntity instances.
   */
  public void setRoles(Set<RoleEntity> roles) {
    this.roles = roles;
  }

  /**
   * <p>Returns the authorities granted to the user.</p>
   *
   * @return User authorities.
   */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return getRoles();
  }

  /**
   * <p>Indicates whether the user's account has expired.</p>
   *
   * @return <code>true</code> if the user's account is valid.
   */
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  /**
   * <p>Indicates whether the user is locked or unlocked.</p>
   *
   * @return <code>true</code> if the user is not locked.
   */
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  /**
   * <p>Indicates whether the user's credentials has expired.</p>
   *
   * @return <code>true</code> if the user's credentials are valid.
   */
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /**
   * <p>Indicates whether the user is enabled or disabled.</p>
   *
   * @return <code>true</code> if the user is enabled.
   */
  @Override
  public boolean isEnabled() {
    return true;
  }
}
