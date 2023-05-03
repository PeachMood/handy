package team.zavod.handy.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.zavod.handy.service.user.UserService;

/** Handles endpoints related to users. */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
  private final ConversionService conversionService; // For type conversion purposes
  private final UserService userService; // Instance of UserService

  /**
   * Constructs new instance of <code>UserController</code> class.
   *
   * @param conversionService For type conversion Purposes.
   * @param userService Instance of UserService.
   */
  @Autowired
  public UserController(ConversionService conversionService, UserService userService) {
    this.conversionService = conversionService;
    this.userService = userService;
  }
}
