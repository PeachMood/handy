package team.zavod.handy.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.CacheControlConfig;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;
import team.zavod.handy.repository.jwt.JwtAccessTokenRepository;
import team.zavod.handy.repository.jwt.JwtRefreshTokenRepository;
import team.zavod.handy.security.HttpStatusReturningAuthenticationFailureHandler;
import team.zavod.handy.security.HttpStatusReturningAuthenticationSuccessHandler;
import team.zavod.handy.security.jwt.JwtAuthenticationFilter;
import team.zavod.handy.security.jwt.JwtAuthenticationProvider;
import team.zavod.handy.security.usernamepassword.UsernamePasswordDtoAuthenticationFilter;
import team.zavod.handy.service.user.UserService;

/** Configures various security related aspects. */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
  @Bean
  public SecurityFilterChain filterChain(
      HttpSecurity http,
      JwtAuthenticationProvider jwtAuthenticationProvider,
      FilterRegistrationBean<JwtAuthenticationFilter> jwtAuthenticationFilter,
      FilterRegistrationBean<UsernamePasswordDtoAuthenticationFilter>
          usernamePasswordDtoAuthenticationFilter,
      LogoutSuccessHandler logoutSuccessHandler)
      throws Exception {
    http.headers(
            (headers) ->
                headers
                    .frameOptions(FrameOptionsConfig::sameOrigin)
                    .cacheControl(CacheControlConfig::disable))
        .cors(Customizer.withDefaults())
        .sessionManagement(
            (sessionManagement) ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(
            (authorizeHttpRequests) ->
                authorizeHttpRequests
                    .requestMatchers("/api/auth/**")
                    .permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/user/**")
                    .hasRole("ADMIN")
                    .anyRequest()
                    .authenticated())
        .csrf(AbstractHttpConfigurer::disable)
        .logout(
            (logout) ->
                logout
                    .logoutUrl("/api/user/logout")
                    .permitAll()
                    .logoutSuccessHandler(logoutSuccessHandler))
        .httpBasic(AbstractHttpConfigurer::disable)
        .authenticationProvider(jwtAuthenticationProvider)
        .addFilterAfter(
            usernamePasswordDtoAuthenticationFilter.getFilter(), AuthorizationFilter.class)
        .addFilterAfter(jwtAuthenticationFilter.getFilter(), AuthorizationFilter.class);
    return http.build();
  }

  @Bean
  public JwtAuthenticationProvider jwtAuthenticationProvider(
      ApplicationConfiguration applicationConfiguration, UserService userService) {
    return new JwtAuthenticationProvider(applicationConfiguration, userService);
  }

  @Bean
  public FilterRegistrationBean<JwtAuthenticationFilter> jwtAuthenticationFilter(
      AuthenticationManager authenticationManager,
      JwtAccessTokenRepository jwtAccessTokenRepository,
      JwtRefreshTokenRepository jwtRefreshTokenRepository,
      AuthenticationSuccessHandler authenticationSuccessHandler,
      AuthenticationFailureHandler authenticationFailureHandler) {
    JwtAuthenticationFilter jwtAuthenticationFilter =
        new JwtAuthenticationFilter(
            authenticationManager, jwtAccessTokenRepository, jwtRefreshTokenRepository);
    jwtAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
    jwtAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
    FilterRegistrationBean<JwtAuthenticationFilter> filterRegistrationBean =
        new FilterRegistrationBean<>();
    filterRegistrationBean.setFilter(jwtAuthenticationFilter);
    filterRegistrationBean.setEnabled(false);
    return filterRegistrationBean;
  }

  @Bean
  public FilterRegistrationBean<UsernamePasswordDtoAuthenticationFilter>
      usernamePasswordDtoAuthenticationFilter(
          AuthenticationManager authenticationManager,
          AuthenticationSuccessHandler authenticationSuccessHandler,
          AuthenticationFailureHandler authenticationFailureHandler) {
    UsernamePasswordDtoAuthenticationFilter usernamePasswordDtoAuthenticationFilter =
        new UsernamePasswordDtoAuthenticationFilter(authenticationManager);
    usernamePasswordDtoAuthenticationFilter.setAuthenticationSuccessHandler(
        authenticationSuccessHandler);
    usernamePasswordDtoAuthenticationFilter.setAuthenticationFailureHandler(
        authenticationFailureHandler);
    FilterRegistrationBean<UsernamePasswordDtoAuthenticationFilter> filterRegistrationBean =
        new FilterRegistrationBean<>();
    filterRegistrationBean.setFilter(usernamePasswordDtoAuthenticationFilter);
    filterRegistrationBean.setEnabled(false);
    return filterRegistrationBean;
  }

  @Bean
  public LogoutSuccessHandler logoutSuccessHandler() {
    return new HttpStatusReturningLogoutSuccessHandler();
  }

  @Bean
  public AuthenticationSuccessHandler authenticationSuccessHandler() {
    return new HttpStatusReturningAuthenticationSuccessHandler();
  }

  @Bean
  public AuthenticationFailureHandler authenticationFailureHandler() {
    return new HttpStatusReturningAuthenticationFailureHandler();
  }

  @Bean
  public AuthenticationManager authenticationManager(
      HttpSecurity http, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService)
      throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
        .userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder)
        .and()
        .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
