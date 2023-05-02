package team.zavod.handy.service.user;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.zavod.handy.model.entity.user.SettingsEntity;
import team.zavod.handy.repository.user.SettingsRepository;

/**
 * <p>Implements complex logic related to user settings.</p>
 */
@Service
public class SettingsService {
  private final SettingsRepository settingsRepository;    // instance of user SettingsRepository

  /**
   * <p>Constructs new instance of <code>SettingsService</code> class.</p>
   *
   * @param settingsRepository Instance of user SettingsRepository.
   */
  @Autowired
  public SettingsService(SettingsRepository settingsRepository) {
    this.settingsRepository = settingsRepository;
  }

  /**
   * <p>Creates new user settings with the specified data.</p>
   *
   * @param settings User settings to be created.
   * @return <code>true</code> if SettingsRepository was changed as a result of this call,
   * or <code>false</code> otherwise.
   */
  @Transactional
  public boolean createSettings(SettingsEntity settings) {
    this.settingsRepository.save(settings);
    return true;
  }

  /**
   * <p>Finds settings by id.</p>
   *
   * @param id Settings id to be found.
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return User settings with the specified id if such settings exist,
   * or <code>null</code> otherwise.
   */
  public <T> T findSettings(Long id, Class<T> type) {
    return this.settingsRepository.findById(id, type)
        .orElse(null);
  }

  /**
   * <p>Gets <code>List</code> of all settings.</p>
   *
   * @param type Class to be returned.
   * @param <T> Type parameter for returning class.
   * @return <code>List</code> of all settings.
   */
  public <T> List<T> findAllSettings(Class<T> type) {
    return this.settingsRepository.findAllProjectedBy(type);
  }

  /**
   * <p>Updates settings with the specified data.</p>
   *
   * @param with Settings to be updated.
   * @return <code>true</code> if SettingsRepository was changed as a result of this call,
   * or <code>false</code> otherwise.
   */
  @Transactional
  public boolean updateSettings(SettingsEntity with) {
    SettingsEntity current = findSettings(with.getId(), SettingsEntity.class);
    if(Objects.isNull(current)) {
      return false;
    }
    this.settingsRepository.save(with);
    return true;
  }

  /**
   * <p>Deletes settings by id.</p>
   *
   * @param id Settings id to be deleted.
   * @return <code>true</code> if SettingsRepository was changed as a result of this call,
   * or <code>false</code> otherwise.
   */
  @Transactional
  public boolean deleteSettings(Long id) {
    if(Objects.isNull(findSettings(id, SettingsEntity.class))) {
      return false;
    }
    this.settingsRepository.deleteById(id);
    return true;
  }
}
