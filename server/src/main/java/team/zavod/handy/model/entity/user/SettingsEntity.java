package team.zavod.handy.model.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * <p>Stores user settings.</p>
 */
@Entity(name = "Settings")
@Table(name = "settings")
public class SettingsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;    // Unique settings identifier
  @Column(name = "trashed_period")
  private int trashedPeriod;    // Time for storing data in trash

  /**
   * <p>Constructs new instance of <code>SettingsEntity</code> class.</p>
   */
  public SettingsEntity() {
  }

  /**
   * <p>Constructs new instance of <code>SettingsEntity</code> class.</p>
   *
   * @param id Unique settings identifier.
   * @param trashedPeriod Time for storing data in trash.
   */
  public SettingsEntity(Long id, int trashedPeriod) {
    this.id = id;
    this.trashedPeriod = trashedPeriod;
  }

  /**
   * <p>Getter for <code>id</code> field.</p>
   *
   * @return Unique settings identifier.
   */
  public Long getId() {
    return this.id;
  }

  /**
   * <p>Setter for <code>trashedPeriod</code> field.</p>
   *
   * @param id Unique settings identifier.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * <p>Getter for <code>trashedPeriod</code> field.</p>
   *
   * @return Time for storing data in trash.
   */
  public int getTrashedPeriod() {
    return this.trashedPeriod;
  }

  /**
   * <p>Setter for <code>trashedPeriod</code> field.</p>
   *
   * @param trashedPeriod Time for storing data in trash.
   */
  public void setTrashedPeriod(int trashedPeriod) {
    this.trashedPeriod = trashedPeriod;
  }
}