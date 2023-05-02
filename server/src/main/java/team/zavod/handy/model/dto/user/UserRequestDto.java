package team.zavod.handy.model.dto.user;

/**
 * <p>Represents single user as a request to the server.</p>
 *
 * @param id Unique user identifier.
 * @param username Unique user name.
 * @param email User's e-mail address.
 * @param password Hash of user's password.
 */
public record UserRequestDto(Long id, String username, String email, String password) {
}
