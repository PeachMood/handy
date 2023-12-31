package team.zavod.handy.model.dto.user;

/**
 * Represents single user as a request to the server.
 *
 * @param id Unique user identifier.
 * @param username Unique user name.
 * @param email User's e-mail address.
 * @param password Hash of user's password.
 */
public record UserRequestDto(String username, String email, String password) {}
