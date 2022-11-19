package io.gitlab.zavod.handy.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Entry point for server application.</p>
 */
@SpringBootApplication
public class ServerApplication {
    /**
     * <p>Starts Spring WEB-Server.</p>
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
