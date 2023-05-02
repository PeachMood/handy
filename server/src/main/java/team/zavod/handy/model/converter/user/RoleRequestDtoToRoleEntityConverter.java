package team.zavod.handy.model.converter.user;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.user.RoleRequestDto;
import team.zavod.handy.model.entity.user.RoleEntity;

/**
 * <p>Converts RoleRequestDto to RoleEntity.</p>
 */
public class RoleRequestDtoToRoleEntityConverter implements Converter<RoleRequestDto, RoleEntity> {
  /**
   * <p>Converts <code>RoleRequestDto</code> to <code>RoleEntity</code>.</p>
   *
   * @param source RoleRequestDto to convert.
   * @return Converted RoleEntity.
   */
  @Override
  public RoleEntity convert(RoleRequestDto source) {
    RoleEntity target = new RoleEntity();
    target.setId(source.id());
    target.setName(source.name());
    return target;
  }
}
