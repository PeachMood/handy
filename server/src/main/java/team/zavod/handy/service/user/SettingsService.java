package team.zavod.handy.service.user;

import team.zavod.handy.repository.user.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Implements complex logic related to user settings.</p>
 */
@Service
public class SettingsService {
  private final SettingsRepository repository;    // instance of SettingsRepository

  /**
   * <p>Creates instance of <code>SettingsService</code> class.</p>
   *
   * @param repository Instance of SettingsRepository.
   */
  @Autowired
  public SettingsService(SettingsRepository repository) {
    this.repository = repository;
  }
}
