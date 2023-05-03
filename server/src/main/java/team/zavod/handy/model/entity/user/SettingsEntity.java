package team.zavod.handy.model.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/** Stores user settings. */
@Entity(name = "Settings")
@Table(name = "settings")
public class SettingsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // Unique settings identifier

  @Column(name = "trashed_period")
  private int trashedPeriod; // Time for storing data in trash

  /** Constructs new instance of <code>SettingsEntity</code> class. */
  public SettingsEntity() {}

  /**
   * Constructs new instance of <code>SettingsEntity</code> class.
   *
   * @param id Unique settings identifier.
   * @param trashedPeriod Time for storing data in trash.
   */
  public SettingsEntity(Long id, int trashedPeriod) {
    this.id = id;
    this.trashedPeriod = trashedPeriod;
  }

  /**
   * Getter for <code>id</code> field.
   *
   * @return Unique settings identifier.
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Setter for <code>trashedPeriod</code> field.
   *
   * @param id Unique settings identifier.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Getter for <code>trashedPeriod</code> field.
   *
   * @return Time for storing data in trash.
   */
  public int getTrashedPeriod() {
    return this.trashedPeriod;
  }

  /**
   * Setter for <code>trashedPeriod</code> field.
   *
   * @param trashedPeriod Time for storing data in trash.
   */
  public void setTrashedPeriod(int trashedPeriod) {
    this.trashedPeriod = trashedPeriod;
  }
}
