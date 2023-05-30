package team.zavod.handy.model.converter.user;

import org.springframework.core.convert.converter.Converter;
import team.zavod.handy.model.dto.user.RoleResponseDto;
import team.zavod.handy.model.entity.user.RoleEntity;

/** Converts RoleEntity to RoleResponseDto. */
public class RoleEntityToRoleResponseDtoConverter
    implements Converter<RoleEntity, RoleResponseDto> {
  /**
   * Converts <code>RoleEntity</code> to <code>RoleResponseDto</code>.
   *
   * @param source RoleEntity to convert.
   * @return Converted RoleResponseDto.
   */
  @Override
  public RoleResponseDto convert(RoleEntity source) {
    return new RoleResponseDto(source.getId(), source.getName());
  }
}
