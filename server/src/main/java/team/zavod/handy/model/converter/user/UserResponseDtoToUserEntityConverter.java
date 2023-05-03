package team.zavod.handy.model.converter.user;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.user.UserResponseDto;
import team.zavod.handy.model.entity.user.UserEntity;

/** Converts UserResponseDto to UserEntity. */
public class UserResponseDtoToUserEntityConverter
    implements Converter<UserResponseDto, UserEntity> {
  /**
   * Converts <code>UserResponseDto</code> to <code>UserEntity</code>.
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
