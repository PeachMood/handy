package team.zavod.handy.repository.user;

import team.zavod.handy.entity.user.SettingsEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Provides functionality to manage settings.</p>
 */
@Repository
public interface SettingsRepository extends JpaRepository<SettingsEntity, Long> {
  /**
   * <p>Creates new settings with the specified data.</p>
   *
   * @param id Unique settings identifier.
   * @param trashedPeriod Time for storing data in trash.
   */
  void save(Long id, int trashedPeriod);

  /**
   * <p>Finds settings by id.</p>
   *
   * @param id Settings id to be found.
   * @return <code>Optional&lt;SettingsEntity&gt;</code> instance with the specified id.
   */
  Optional<SettingsEntity> findById(Long id);

  /**
   * <p>Gets <code>List</code> of all settings.</p>
   *
   * @return <code>List</code> of all settings.
   */
  List<SettingsEntity> findAll();

  /**
   * <p>Deletes settings by id.</p>
   *
   * @param id Settings id to be deleted.
   */
  void deleteById(Long id);
}
