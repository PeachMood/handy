package team.zavod.handy;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import team.zavod.handy.configuration.ApplicationConfiguration;

/**
 * <p>Entry point for server application.</p>
 */
@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfiguration.class)
public class HandyServer {
  /**
   * <p>Starts Spring WEB-Server.</p>
   *
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    new SpringApplicationBuilder(HandyServer.class)
        .logStartupInfo(false)
        .bannerMode(Mode.OFF)
        .run(args);
  }
}
