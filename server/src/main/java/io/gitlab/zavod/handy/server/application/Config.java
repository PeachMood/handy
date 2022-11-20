package io.gitlab.zavod.handy.server.application;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>Stores application configuration.</p>
 */
@ConfigurationProperties
public record Config() {
}
