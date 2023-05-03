package team.zavod.handy.model.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import org.springframework.security.core.GrantedAuthority;

/** Represents user authority. */
@Entity(name = "Role")
@Table(name = "role")
public class RoleEntity implements GrantedAuthority {
  @Transient
  public static final String DEFAULT_ROLE =
      "ROLE_USER"; // Role which will be assigned as a default value

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // Unique role identifier

  private String name; // Role name

  /** Constructs new instance of <code>RoleEntity</code> class. */
  public RoleEntity() {}

  /**
   * Constructs new instance of <code>RoleEntity</code> class.
   *
   * @param id Unique role identifier.
   * @param name Role name.
   */
  public RoleEntity(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Getter for <code>id</code> field.
   *
   * @return Unique role identifier.
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Setter for <code>id</code> field.
   *
   * @param id Unique role identifier.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Getter for <code>name</code> field.
   *
   * @return Role name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Setter for <code>name</code> field.
   *
   * @param name Role name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns <code>String</code> representation of the <code>GrantedAuthority</code>.
   *
   * @return <code>String</code> representation of the <code>GrantedAuthority</code>.
   */
  @Override
  public String getAuthority() {
    return getName();
  }
}
