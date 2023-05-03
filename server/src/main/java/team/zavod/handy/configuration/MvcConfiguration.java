package team.zavod.handy.configuration;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import team.zavod.handy.model.converter.note.NoteRequestDtoToNoteEntityConverter;
import team.zavod.handy.model.converter.note.NoteResponseDtoToNoteEntityConverter;
import team.zavod.handy.model.converter.user.RoleRequestDtoToRoleEntityConverter;
import team.zavod.handy.model.converter.user.RoleResponseDtoToRoleEntityConverter;
import team.zavod.handy.model.converter.user.SettingsRequestDtoToSettingsEntityConverter;
import team.zavod.handy.model.converter.user.SettingsResponseDtoToSettingsEntityConverter;
import team.zavod.handy.model.converter.user.UserRequestDtoToUserEntityConverter;
import team.zavod.handy.model.converter.user.UserResponseDtoToUserEntityConverter;

/** Configures various MVC related aspects. */
@Configuration
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {
  private static final long MAX_AGE = 30; // Max age for cors (in minutes)
  private final ApplicationConfiguration applicationConfiguration;

  @Autowired
  public MvcConfiguration(ApplicationConfiguration applicationConfiguration) {
    this.applicationConfiguration = applicationConfiguration;
  }

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new NoteRequestDtoToNoteEntityConverter());
    registry.addConverter(new NoteResponseDtoToNoteEntityConverter());
    registry.addConverter(new RoleRequestDtoToRoleEntityConverter());
    registry.addConverter(new RoleResponseDtoToRoleEntityConverter());
    registry.addConverter(new SettingsRequestDtoToSettingsEntityConverter());
    registry.addConverter(new SettingsResponseDtoToSettingsEntityConverter());
    registry.addConverter(new UserRequestDtoToUserEntityConverter());
    registry.addConverter(new UserResponseDtoToUserEntityConverter());
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        .allowedOrigins(this.applicationConfiguration.cors().allowedOrigins())
        .allowCredentials(true)
        .maxAge(TimeUnit.MINUTES.toSeconds(MAX_AGE));
  }
}
