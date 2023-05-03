package team.zavod.handy.model.dto.user;

/**
 * Represents user settings as a response for the client.
 *
 * @param id Unique settings identifier.
 * @param trashedPeriod Time for storing data in trash.
 */
public record SettingsResponseDto(Long id, int trashedPeriod) {}
