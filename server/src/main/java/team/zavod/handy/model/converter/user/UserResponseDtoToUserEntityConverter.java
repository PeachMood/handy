package team.zavod.handy.model.converter.user;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.user.UserResponseDto;
import team.zavod.handy.model.entity.user.UserEntity;

/**
 * <p>Converts UserResponseDto to UserEntity.</p>
 */
public class UserResponseDtoToUserEntityConverter implements Converter<UserResponseDto, UserEntity> {
  /**
   * <p>Converts <code>UserResponseDto</code> to <code>UserEntity</code>.</p>
   *
   * @param source UserResponseDto to convert.
   * @return Converted UserEntity.
   */
  @Override
  public UserEntity convert(UserResponseDto source) {
    UserEntity target = new UserEntity();
    target.setId(source.id());
    target.setUsername(source.username());
    target.setEmail(source.email());
    target.setAvatar(source.avatar());
    return target;
  }
}
