package team.zavod.handy.model.dto.user;

/**
 * <p>Represents user authority as a request to the server.</p>
 *
 * @param id Unique role identifier.
 * @param name Role name.
 */
public record RoleRequestDto(Long id, String name) {
}