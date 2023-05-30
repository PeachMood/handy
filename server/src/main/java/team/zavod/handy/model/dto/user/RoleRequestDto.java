package team.zavod.handy.model.dto.user;

/**
 * Represents user authority as a request to the server.
 *
 * @param id Unique role identifier.
 * @param name Role name.
 */
public record RoleRequestDto(String name) {}
