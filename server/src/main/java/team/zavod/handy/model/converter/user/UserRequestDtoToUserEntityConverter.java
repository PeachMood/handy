package team.zavod.handy.model.converter.user;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.user.UserRequestDto;
import team.zavod.handy.model.entity.user.UserEntity;

/**
 * <p>Converts UserRequestDto to UserEntity.</p>
 */
public class UserRequestDtoToUserEntityConverter implements Converter<UserRequestDto, UserEntity> {
  /**
   * <p>Converts <code>UserRequestDto</code> to <code>UserEntity</code>.</p>
   *
   * @param source UserRequestDto to convert.
   * @return Converted UserEntity.
   */
  @Override
  public UserEntity convert(UserRequestDto source) {
    UserEntity target = new UserEntity();
    target.setId(source.id());
    target.setUsername(source.username());
    target.setEmail(source.email());
    target.setPassword(source.password());
    return target;
  }
}
