package team.zavod.handy.configuration;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfiguration {

  @Bean
  public Flyway flyway(DataSource dataSource) {
    Flyway flyway =
        Flyway.configure().dataSource(dataSource).locations("classpath:/db/migration").load();
    flyway.migrate();
    return flyway;
  }
}
