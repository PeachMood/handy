package team.zavod.handy.model.converter.user;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.user.RoleResponseDto;
import team.zavod.handy.model.entity.user.RoleEntity;

/**
 * <p>Converts RoleResponseDto to RoleEntity.</p>
 */
public class RoleResponseDtoToRoleEntityConverter implements Converter<RoleResponseDto, RoleEntity> {
  /**
   * <p>Converts <code>RoleResponseDto</code> to <code>RoleEntity</code>.</p>
   *
   * @param source RoleResponseDto to convert.
   * @return Converted RoleEntity.
   */
  @Override
  public RoleEntity convert(RoleResponseDto source) {
    RoleEntity target = new RoleEntity();
    target.setId(source.id());
    target.setName(source.name());
    return target;
  }
}
