package team.zavod.handy.model.converter.user;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.user.UserResponseDto;
import team.zavod.handy.model.entity.user.UserEntity;

/** Converts UserEntity to UserResponseDto. */
public class UserEntityToUserResponseDtoConverter
    implements Converter<UserEntity, UserResponseDto> {
  /**
   * Converts <code>UserEntity</code> to <code>UserResponseDto</code>.
   *
   * @param source UserEntity to convert.
   * @return Converted UserResponseDto.
   */
  @Override
  public UserResponseDto convert(UserEntity source) {
    return new UserResponseDto(
        source.getId(), source.getUsername(), source.getEmail(), source.getAvatar());
  }
}
