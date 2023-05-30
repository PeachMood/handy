package team.zavod.handy.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.zavod.handy.model.dto.jwt.JwtTokenDto;
import team.zavod.handy.model.dto.user.UserRequestDto;
import team.zavod.handy.model.entity.jwt.JwtAccessToken;
import team.zavod.handy.model.entity.jwt.JwtRefreshToken;
import team.zavod.handy.model.entity.user.UserEntity;
import team.zavod.handy.service.AuthorizationService;
import team.zavod.handy.service.user.UserService;

/** Handles endpoints related to authorization. */
@RestController
@RequestMapping(value = "/api/auth")
public class AuthorizationController {
  private final ConversionService conversionService; // For type conversion purposes
  private final AuthorizationService authorizationService; // Instance of AuthorizationService
  private final UserService userService; // Instance of UserService

  /**
   * Constructs new instance of <code>AuthorizationController</code> class.
   *
   * @param authorizationService Instance of AuthorizationService.
   */
  @Autowired
  public AuthorizationController(
      ConversionService conversionService,
      AuthorizationService authorizationService,
      UserService userService) {
    this.conversionService = conversionService;
    this.authorizationService = authorizationService;
    this.userService = userService;
  }

  /**
   * Registers new user with the specified data.
   *
   * @param userRequestDto User to be registered.
   * @return Response indicating status of registration.
   */
  @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> register(@RequestBody UserRequestDto userRequestDto) {
    UserEntity user = this.conversionService.convert(userRequestDto, UserEntity.class);
    if (Objects.isNull(user)) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid userdata");
    }
    if (!this.userService.createUser(user)) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
    }
    return ResponseEntity.status(HttpStatus.OK).body("Registration succeeded");
  }

  /**
   * Generates JWT tokens for authorized user.
   *
   * @param request HTTP request to use.
   * @param response HTTP response to use.
   * @return Tokens for authorized user.
   */
  @PostMapping(
      value = "/login",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public JwtTokenDto login(HttpServletRequest request, HttpServletResponse response) {
    return sendToken(request, response);
  }

  /**
   * Refreshes JWT tokens for authorized user.
   *
   * @param request HTTP request to use.
   * @param response HTTP response to use.
   * @return Tokens for authorized user.
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
    return new JwtTokenDto(
        jwtAccessToken.getType(),
        (int) this.authorizationService.getAccessTokenExpirationTime(),
        jwtAccessToken.getToken(),
        jwtRefreshToken.getToken());
  }
}
