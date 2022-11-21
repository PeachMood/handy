package team.zavod.handy.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * <p>Entry point for server application.</p>
 */
@SpringBootApplication
@EnableConfigurationProperties(Config.class)
public class HandyServer {
  /**
   * <p>Starts Spring WEB-Server.</p>
   *
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    SpringApplication.run(HandyServer.class, args);
  }
}
