package team.zavod.handy.model.dto.user;

/**
 * <p>Represents user settings as a request to the server.</p>
 *
 * @param id Unique settings identifier.
 * @param trashedPeriod Time for storing data in trash.
 */
public record SettingsRequestDto(Long id, int trashedPeriod) {
}
