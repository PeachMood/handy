package team.zavod.handy.model.dto.user;

/**
 * Represents single user as a response for the client.
 *
 * @param id Unique user identifier.
 * @param username Unique user name.
 * @param email User's e-mail address.
 * @param avatar Path to user's avatar.
 */
public record UserResponseDto(Long id, String username, String email, String avatar) {}
