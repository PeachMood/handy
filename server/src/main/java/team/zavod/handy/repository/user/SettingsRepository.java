package team.zavod.handy.repository.user;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.zavod.handy.model.entity.user.SettingsEntity;

/** Provides functionality to manage settings. */
@Repository
public interface SettingsRepository extends JpaRepository<SettingsEntity, Long> {
  /**
   * Creates new settings with the specified data.
   *
   * @param settings User settings to be saved.
   */
  @SuppressWarnings("unchecked")
  SettingsEntity save(SettingsEntity settings);

  /**
   * Finds settings by id.
   *
   * @param id Settings id to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>Optional&lt;T&gt;</code> instance with the specified id.
   */
  <T> Optional<T> findById(Long id, Class<T> type);

  /**
   * Gets <code>List</code> of all settings.
   *
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all settings.
   */
  <T> List<T> findAllProjectedBy(Class<T> type);

  /**
   * Deletes settings by id.
   *
   * @param id Settings id to be deleted.
   */
  void deleteById(Long id);
}
