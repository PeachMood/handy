package team.zavod.handy.model.converter.user;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.user.RoleResponseDto;
import team.zavod.handy.model.entity.user.RoleEntity;

/** Converts RoleResponseDto to RoleEntity. */
public class RoleResponseDtoToRoleEntityConverter
    implements Converter<RoleResponseDto, RoleEntity> {
  /**
   * Converts <code>RoleResponseDto</code> to <code>RoleEntity</code>.
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
