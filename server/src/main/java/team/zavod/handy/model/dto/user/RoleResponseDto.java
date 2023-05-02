package team.zavod.handy.model.dto.user;

/**
 * <p>Represents user authority as a response for the client.</p>
 *
 * @param id Unique role identifier.
 * @param name Role name.
 */
public record RoleResponseDto(Long id, String name) {
}
