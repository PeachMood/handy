package io.gitlab.zavod.handy.server.storage.entity.user;

/**
 * <p>Stores user settings.</p>
 */
public class SettingsEntity {
  private final int id;    // Unique settings identifier
  private int trashedPeriod;    // Time for storing data in trash

  /**
   * <p>Constructs new instance of <code>SettingsEntity</code> class.</p>
   *
   * @param id            Unique settings identifier.
   * @param trashedPeriod Time for storing data in trash.
   */
  public SettingsEntity(int id, int trashedPeriod) {
    this.id = id;
    this.trashedPeriod = trashedPeriod;
  }

  /**
   * <p>Getter for <code>id</code> field.</p>
   *
   * @return Unique user identifier.
   */
  public int getId() {
    return this.id;
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
