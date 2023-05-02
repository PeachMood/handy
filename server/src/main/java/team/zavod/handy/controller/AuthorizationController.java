package team.zavod.handy.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.zavod.handy.model.dto.jwt.JwtTokenDto;
import team.zavod.handy.model.entity.jwt.JwtAccessToken;
import team.zavod.handy.model.entity.jwt.JwtRefreshToken;
import team.zavod.handy.service.AuthorizationService;

/**
 * <p>Handles endpoints related to authorization.</p>
 */
@RestController
@RequestMapping(value = "/api/auth")
public class AuthorizationController {
  private final AuthorizationService authorizationService;    // Instance of AuthorizationService

  /**
   * <p>Constructs new instance of <code>AuthorizationController</code> class.</p>
   *
   * @param authorizationService Instance of AuthorizationService.
   */
  @Autowired
  public AuthorizationController(AuthorizationService authorizationService) {
    this.authorizationService = authorizationService;
  }

  /**
   * <p>Generates JWT tokens for authorized user.</p>
   *
   * @param request HTTP request to use.
   * @param response HTTP response to use.
   */
  @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public JwtTokenDto login(HttpServletRequest request, HttpServletResponse response) {
    return sendToken(request, response);
  }

  /**
   * <p>Refreshes JWT tokens for authorized user.</p>
   *
   * @param request HTTP request to use.
   * @param response HTTP response to use.
   */
  @GetMapping(value = "/refresh-token", produces = MediaType.APPLICATION_JSON_VALUE)
  public JwtTokenDto refreshToken(HttpServletRequest request, HttpServletResponse response) {
    return sendToken(request, response);
  }

  /* Tries to send JWT tokens */
  private JwtTokenDto sendToken(HttpServletRequest request, HttpServletResponse response) {
    JwtAccessToken jwtAccessToken = this.authorizationService.generateAccessToken(request);
    JwtRefreshToken jwtRefreshToken = this.authorizationService.generateRefreshToken(request);
    this.authorizationService.saveAccessToken(jwtAccessToken, request, response);
    this.authorizationService.saveRefreshToken(jwtRefreshToken, request, response);
    return new JwtTokenDto(jwtAccessToken.getType(), (int) this.authorizationService.getAccessTokenExpirationTime(), jwtAccessToken.getToken(), jwtRefreshToken.getToken());
  }
}
