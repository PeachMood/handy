package team.zavod.handy.model.converter.user;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.user.UserRequestDto;
import team.zavod.handy.model.entity.user.UserEntity;

/** Converts UserRequestDto to UserEntity. */
public class UserRequestDtoToUserEntityConverter implements Converter<UserRequestDto, UserEntity> {
  /**
   * Converts <code>UserRequestDto</code> to <code>UserEntity</code>.
   *
   * @param source UserRequestDto to convert.
   * @return Converted UserEntity.
   */
  @Override
  public UserEntity convert(UserRequestDto source) {
    UserEntity target = new UserEntity();
    target.setUsername(source.username());
    target.setEmail(source.email());
    target.setPassword(source.password());
    return target;
  }
}
