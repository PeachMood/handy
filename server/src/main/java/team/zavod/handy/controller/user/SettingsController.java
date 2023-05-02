package team.zavod.handy.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.zavod.handy.service.user.SettingsService;

/**
 * <p>Handles endpoints related to user settings.</p>
 */
@RestController
@RequestMapping(value = "/api/user/settings")
public class SettingsController {
  private final ConversionService conversionService;    // For type conversion purposes
  private final SettingsService settingsService;    // Instance of user SettingsService

  /**
   * <p>Constructs new instance of <code>SettingsController</code> class.</p>
   *
   * @param conversionService For type conversion Purposes.
   * @param settingsService Instance of user SettingsService.
   */
  @Autowired
  public SettingsController(ConversionService conversionService, SettingsService settingsService) {
    this.conversionService = conversionService;
    this.settingsService = settingsService;
  }
}
