package team.zavod.handy.model.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import org.springframework.security.core.GrantedAuthority;

/**
 * <p>Represents user authority.</p>
 */
@Entity(name = "Role")
@Table(name = "role")
public class RoleEntity implements GrantedAuthority {
  @Transient
  public static final String DEFAULT_ROLE = "ROLE_USER";    // Role which will be assigned as a default value
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;    // Unique role identifier
  private String name;    // Role name

  /**
   * <p>Constructs new instance of <code>RoleEntity</code> class.</p>
   */
  public RoleEntity() {
  }

  /**
   * <p>Constructs new instance of <code>RoleEntity</code> class.</p>
   *
   * @param id Unique role identifier.
   * @param name Role name.
   */
  public RoleEntity(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * <p>Getter for <code>id</code> field.</p>
   *
   * @return Unique role identifier.
   */
  public Long getId() {
    return this.id;
  }

  /**
   * <p>Setter for <code>id</code> field.</p>
   *
   * @param id Unique role identifier.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * <p>Getter for <code>name</code> field.</p>
   *
   * @return Role name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * <p>Setter for <code>name</code> field.</p>
   *
   * @param name Role name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * <p>Returns <code>String</code> representation of the <code>GrantedAuthority</code>.</p>
   *
   * @return <code>String</code> representation of the <code>GrantedAuthority</code>.
   */
  @Override
  public String getAuthority() {
    return getName();
  }
}
