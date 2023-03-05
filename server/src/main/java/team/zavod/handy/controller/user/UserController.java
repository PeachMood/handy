package team.zavod.handy.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.zavod.handy.service.user.UserService;

/**
 * <p>Handles endpoints related to users.</p>
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
  private final UserService service;    // Instance of UserService

  /**
   * <p>Creates instance of <code>UserController</code> class.</p>
   *
   * @param service Instance of UserService.
   */
  @Autowired
  public UserController(UserService service) {
    this.service = service;
  }
}
