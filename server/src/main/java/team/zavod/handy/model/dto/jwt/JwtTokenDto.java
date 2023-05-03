package team.zavod.handy.model.dto.jwt;

/**
 * Represents JWT token as a data transfer object.
 *
 * @param tokenType Type of the authentication token.
 * @param expiresIn Expiration time for access token.
 * @param accessToken JWT access token.
 * @param refreshToken JWT refresh token.
 */
public record JwtTokenDto(
    String tokenType, int expiresIn, String accessToken, String refreshToken) {}
