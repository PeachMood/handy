package team.zavod.handy.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.zavod.handy.service.user.RoleService;

/** Handles endpoints related to user roles. */
@RestController
@RequestMapping(value = "/api/user/role")
public class RoleController {
  private final ConversionService conversionService; // For type conversion purposes
  private final RoleService roleService; // Instance of user RoleService.

  /**
   * Constructs new instance of <code>RoleController</code> class.
   *
   * @param conversionService For type conversion Purposes.
   * @param roleService Instance of user RoleService.
   */
  @Autowired
  public RoleController(ConversionService conversionService, RoleService roleService) {
    this.conversionService = conversionService;
    this.roleService = roleService;
  }
}
