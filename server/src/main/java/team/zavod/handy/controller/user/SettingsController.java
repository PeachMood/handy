package team.zavod.handy.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.zavod.handy.service.user.SettingsService;

/**
 * <p>Handles endpoints related to user settings.</p>
 */
@RestController
@RequestMapping(value = "/api/user/settings")
public class SettingsController {
  private final SettingsService service;    // Instance of SettingsService

  /**
   * <p>Creates instance of <code>SettingsController</code> class.</p>
   *
   * @param service Instance of SettingsService.
   */
  @Autowired
  public SettingsController(SettingsService service) {
    this.service = service;
  }
}
