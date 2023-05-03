package team.zavod.handy.model.dto.user;

/**
 * Represents user authority as a response for the client.
 *
 * @param id Unique role identifier.
 * @param name Role name.
 */
public record RoleResponseDto(Long id, String name) {}
