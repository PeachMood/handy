package team.zavod.handy.model.dto.user;

/**
 * <p>Represents user settings as a response for the client.</p>
 *
 * @param id Unique settings identifier.
 * @param trashedPeriod Time for storing data in trash.
 */
public record SettingsResponseDto(Long id, int trashedPeriod) {
}
